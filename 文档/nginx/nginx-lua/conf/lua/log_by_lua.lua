local cjson = require "cjson"
local xtpt_utils = require "xtpt_utils"

ngx.var.xtpt_renho_end_time = ngx.now()
local log_json = {}
-- 请求端地址
log_json["remote_addr"] = ngx.var.remote_addr
-- method uri httpversion
log_json["request"] = ngx.var.request
-- 当前的Unix时间戳
log_json["msec"] = ngx.var.msec
-- 后端服务响应时间 间隔
log_json["upstream_response_time"] = ngx.var.upstream_response_time
-- 全称响应时间 间隔
log_json["request_time"] = ngx.var.request_time
-- 请求报文
-- log_json["request_body"] = ngx.var.request_body
-- 请求开始时间
log_json["start_time"] = ngx.req.start_time()
-- ?
log_json["xtpt_request_start_time"] = ngx.var.xtpt_request_start_time
-- 当前时间 时间戳
log_json["xtpt_renho_end_time"] = ngx.now()
-- 接收响应开始时间
log_json["xtpt_receive_response_start"] = ngx.var.xtpt_receive_response_start
-- 接收响应结束时间
log_json["xtpt_receive_response_end"] = ngx.var.xtpt_receive_response_end
-- 唯一ID
log_json["xtpt-header-id"] = ngx.req.get_headers()[xtpt_utils.P.BUSI_HEADER_KEY]

-- 响应报文
-- log_json["xtpt_resp_body"] = ngx.var.xtpt_resp_body

log_json["xtpt_busi_type"] = ngx.var.xtpt_busi_type

local status, msg = pcall(xtpt_utils.get_xtpt_header, ngx.var.request_body)
if status then
	log_json["xtpt_req_body_header"] = msg
else
	log_json["xtpt_req_body"] = ngx.var.request_body
end

status, msg = pcall(xtpt_utils.get_xtpt_header, ngx.var.xtpt_resp_body)
if status then
	log_json["xtpt_resp_body_header"] = msg
else
	log_json["xtpt_resp_body"] = ngx.var.xtpt_resp_body
end

local log_json_str = cjson.encode(log_json)

local len, err = ngx.shared.logs:rpush(xtpt_utils.P.SHARED_LOG_KEY.."_"..ngx.var.xtpt_busi_type, log_json_str)
if err then
    xtpt_utils.append_monitor_file(log_json_str, ngx.var.xtpt_busi_type)
    ngx.log(ngx.ERR,"failed to put log vals into shared dict")
    return
end

