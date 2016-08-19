/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
var app = {
	// Application Constructor
	initialize : function() {
		this.bindEvents();
	},
	// Bind Event Listeners
	//
	// Bind any events that are required on startup. Common events are:
	// 'load', 'deviceready', 'offline', and 'online'.
	bindEvents : function() {
		document.addEventListener('deviceready', this.onDeviceReady, false);
	},
	// deviceready Event Handler
	//
	// The scope of 'this' is the event. In order to call the 'receivedEvent'
	// function, we must explicitly call 'app.receivedEvent(...);'
	onDeviceReady : function() {
		app.receivedEvent('deviceready');

		document.getElementById("getPosition").addEventListener("click",
				getPosition);

	},
	// Update DOM on a Received Event
	receivedEvent : function(id) {
		var parentElement = document.getElementById(id);
		var listeningElement = parentElement.querySelector('.listening');
		var receivedElement = parentElement.querySelector('.received');

		listeningElement.setAttribute('style', 'display:none;');
		receivedElement.setAttribute('style', 'display:block;');

		console.log('cordova Received Event: ' + id);
	}
};


app.initialize();


function getPosition() {

   call_photo(callBackfunction)

}

function call_photo(callBackfunction) {

    console.log(cordova);

    cordova.exec(callBackfunction, null, "BridgePlugin", "call_photo", []);
}

function call_camera(callBackfunction) {

    console.log(cordova);

    cordova.exec(callBackfunction, null, "BridgePlugin", "call_camera", []);
}

function see_bigPhoto(json, callBackfunction) {

    cordova.exec(
            callBackfunction,
            null,
            "BridgePlugin",
            "see_bigPhoto",
            [json]);

}

function upload_photo(json, callBackfunction) {

    cordova.exec(
            callBackfunction,
            null,
            "BridgePlugin",
            "upload_photo",
            [json]);

}


function callBackfunction(msg) {
   alert(msg)
//   console.log('imageBase64=' + msg);
//   var image = document.getElementById('myImage');
//   image.src = "data:image/jpeg;base64," + msg;
}

