if ngx.var.xtpt_receive_response_start == "" then
	ngx.var.xtpt_receive_response_start = ngx.now()
end

local resp_body = string.sub(ngx.arg[1], 1, 1024)
ngx.ctx.buffered = (ngx.ctx.buffered or "") .. resp_body
if ngx.arg[2] then
    ngx.var.xtpt_resp_body = ngx.ctx.buffered
    ngx.var.xtpt_receive_response_end = ngx.now()
end