local xtpt_utils = require "xtpt_utils"

ngx.var.xtpt_request_start_time = ngx.req.start_time()

local xtpt_header = ngx.req.get_headers()[xtpt_utils.P.BUSI_HEADER_KEY]
ngx.log(ngx.ERR, "xtpt_header: ", xtpt_header)
if xtpt_header == nil then
    ngx.log(ngx.ERR, "set xtpt_header: ", ngx.var.request_id)
	ngx.req.set_header(xtpt_utils.P.BUSI_HEADER_KEY, ngx.var.request_id)
    ngx.var.xtpt_busi_type = xtpt_utils.P.BUSI_TYPE.REQ
else
    ngx.var.xtpt_busi_type = xtpt_utils.P.BUSI_TYPE.RESP
end
return ngx.req.start_time()