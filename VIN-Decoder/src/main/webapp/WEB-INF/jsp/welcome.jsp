<%@page isELIgnored="false"%>
<html>

<head>
    <title>submit VIN form</title>
    <link rel="stylesheet" type="text/css" href="css/externalStyling.css">
</head>
<body>
<h2>welcome to VIN Decoder</h2>
<form> 
    Enter VIN : <input id="vin" type="text" name="vin"/>
    <input type="button" value="click" onclick="submitAction();">
</form>
   <div id="content"></div>
   <script src="js/restApiCall.js"></script>
   <head>
<script src="js/jquery-3.4.1.js"></script>
</head>
</body>
</html>