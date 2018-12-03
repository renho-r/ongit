local delay = 10
function put_log_into_mysql(premature)      
    local mysql = require "resty.mysql"
    local db, err = mysql:new()
    if not db then
        ngx.log(ngx.ERR,"failed to instantiate mysql: ", err)
        return
    end

    db:set_timeout(1000)
    local ok, err, errcode, sqlstate = db:connect{
        host = "xxx",
        port = 3306,
        database = "database_name",
        user = "username",
        password = "password",
        charset = "utf8",
    }

    if not ok then
        ngx.log(ngx.ERR,"failed to connect: ", err, ": ", errcode, " ", sqlstate)
        return
    end

    -- get data from shared dict and put them into mysql
    local key = "logs"
    local vals = ""
    local temp_val = ngx.shared.logs:lpop(key)
    while (temp_val ~= nil)
    do
        vals = vals .. ",".. temp_val
        temp_val = ngx.shared.logs:lpop(key)
    end

    if vals ~= "" then
        vals = string.sub(vals, 2,-1)
        local command = ("insert into es_visit_record(access_ip,server_ip,access_time,run_time,es_response_time,request_body_byte,run_state,url,post_data) values "..vals)
        ngx.log(ngx.ERR,"command is ",command)
        local res, err, errcode, sqlstate = db:query(command)
        if not res then
            ngx.log(ngx.ERR,"insert error: ", err, ": ", errcode, ": ", sqlstate, ".")
            return
        end
    end

    local ok, err = db:close()
    if not ok then
        ngx.log(ngx.ERR,"failed to close: ", err)
        return
    end
    -- decycle call timer to run put_log_into_mysql method, just like crontab
    local ok, err = ngx.timer.at(delay, put_log_into_mysql);
    if not ok then
        ngx.log(ngx.ERR, "failed to create timer: ", err)
        return
    end
end

local ok, err = ngx.timer.at(delay, put_log_into_mysql)
if not ok then
    ngx.log(ngx.ERR, "failed to create timer: ", err)
    return
end