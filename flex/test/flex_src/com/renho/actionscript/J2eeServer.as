package com.renho.actionscript
{
	import flash.events.EventDispatcher;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.http.HTTPService;
	
	public class J2eeServer extends EventDispatcher
	{
		public function J2eeServer()
		{
		}
		
		public function sendRequest(locale:String):void
		{
			var httpObject:HTTPService = new HTTPService();
			httpObject.resultFormat = "text";
			httpObject.url = "http://localhost:8080/test/renho?locale="+locale;
			var responder:mx.rpc.Responder = new mx.rpc.Responder(onSuccess, onFault);
			var call:AsyncToken = httpObject.send();
			call.addResponder(responder);
		}
		private function onSuccess(event:ResultEvent):void
		{
			this.dispatchEvent(event);   
		}
		
		private function onFault(event:FaultEvent):void
		{
			trace("communication failed!");
			this.dispatchEvent(event); 
		} 
	}
}