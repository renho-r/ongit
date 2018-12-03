local cjson = require "cjson"

local utils = {}

utils.P = {
	THIS_NGINX_ID = "esb_node_10001",
	SHARED_LOG_KEY = "logs",
	SHARED_LOG_REQ_KEY = "logs_req",
	SHARED_LOG_RESP_KEY = "logs_resp",
	LOG_FILE_PATH = "/usr/local/nginx/logs/",
	LOG_FILE_NAME = "xtpt_monitor_",
	LOG_FILE_SUF = ".xtpt.log",
	BUSI_HEADER_KEY = "Xtpt-Header",
	LOG_DELAY = 5,
	BUSI_TYPE = {
		REQ = "req",
		RESP = "resp"
	}
}

function utils.get_xtpt_header(busi_info)
	local status, msg = pcall(cjson.decode, busi_info)
	if status then
		local xtpt_header = msg["header"]
		if xtpt_header ~= nil and xtpt_header ~= "" then
			return cjson.encode(xtpt_header)
		end
	end
	error("do not get xtpt_header")
end

function utils.save_file(file_name, mode, data)
	local file = io.open(file_name, mode)
	if file ~= nil then
	    file:write(data)
	    file:write("\n")
	    file:close()
	else
		ngx.log(ngx.ERR, "failed to write data file: "..file_name)
	end
end

function utils.append_monitor_file(data, busi_type)
	local time_y_m_d = os.date("%Y-%m-%d");
    local file_name = utils.P.LOG_FILE_PATH..utils.P.LOG_FILE_NAME..busi_type.."_"..time_y_m_d..utils.P.LOG_FILE_SUF
	utils.save_file(file_name, "a", data)
end

return utils