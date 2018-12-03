local res = ngx.location.capture("/log", { method = ngx.HTTP_POST})
if res.status == 200 then
	file:write("log ok")
else
	file:write("log error")
end
local resReal = ngx.location.capture("/a"..ngx.var.request_uri, { method = ngx.HTTP_POST})
ngx.say(resReal.body)
