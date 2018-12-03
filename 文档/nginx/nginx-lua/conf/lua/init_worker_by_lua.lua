local xtpt_utils = require "xtpt_utils"

function put_log_into_file(log_key, busi_type)
    local vals = ""
    local temp_val = ngx.shared.logs:lpop(log_key)
    while (temp_val ~= nil)
    do
        vals = vals .. "\n" .. temp_val
        temp_val = ngx.shared.logs:lpop(log_key)
    end

    if vals ~= "" then
        vals = string.sub(vals, 2, -1)
        xtpt_utils.append_monitor_file(vals, busi_type)
    end
end

function put_req_log_into_file()
    put_log_into_file(xtpt_utils.P.SHARED_LOG_REQ_KEY, xtpt_utils.P.BUSI_TYPE.REQ)
end

function put_resp_log_into_file()
    put_log_into_file(xtpt_utils.P.SHARED_LOG_RESP_KEY, xtpt_utils.P.BUSI_TYPE.RESP)
end

function process_log(premature)
    put_req_log_into_file()
    put_resp_log_into_file()
    
    local ok, err = ngx.timer.at(xtpt_utils.P.LOG_DELAY, process_log);
    if not ok then
        ngx.log(ngx.ERR, "failed to create timer: ", err)
        return
    end
end

local ok, err = ngx.timer.at(xtpt_utils.P.LOG_DELAY, process_log)
if not ok then
    ngx.log(ngx.ERR, "failed to create timer: ", err)
    return
end