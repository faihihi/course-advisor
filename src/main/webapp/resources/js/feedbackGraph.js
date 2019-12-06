function BuildChart(labels, values, chartTitle) {
     var ctx = document.getElementById("myChart1").getContext('2d');
     var myChart = new Chart(ctx, {
         type: 'bar',
         data: {
             labels: labels, // Our labels
             datasets: [{
                 label: chartTitle, // Name the series
                 data: values, // Our values
                 backgroundColor: [ // Specify custom colors
                     'rgba(193, 66, 66)',
                     'rgba(191, 127, 63)',
                     'rgba(191, 191, 63)',
                     'rgba(127, 191, 63)',
                     'rgba(63, 191, 63)'
                 ],
                 borderColor: [ // Add custom color borders
                 	 'rgba(77,119,197)',
                      'rgba(77,119,197)',
                      'rgba(77,119,197)',
                      'rgba(77,119,197)',
                      'rgba(77,119,197)'
                 ],
                 borderWidth: 0.5 // Specify bar border width
             }]
         },
         options: {
             responsive: true, // Instruct chart js to respond nicely.
             maintainAspectRatio: false, // Add to prevent default behaviour of full-width/height 
         }
     });
     return myChart;
 }
 
 var json = [ {
 	"number":"23",
 	"title":"Strongly Disagree"
 }, {
 	"number":"56",
 	"title":"Disagree"
 },{
 	"number":"89",
 	"title":"Neutral"
 },{
 	"number":"120",
 	"title":"Agree"
 },{
 	"number":"67",
 	"title":"Strongly Agree"
 }];
 
 console.log(json);
 //Map json values back to label array
 var labels = json.map(function (e) {
  return e.title;
 });
 console.log(labels);
 //Map json values back to values array
 var values = json.map(function (e) {
  return e.number;
 });
 console.log(values);	
 
 
 function BuildSurveyChart(labels, values, chartTitle) {
	    var ctx = document.getElementById("myChart").getContext('2d');
	    var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: labels, // Our labels
	            datasets: [{
	                label: chartTitle, // Name the series
	                data: values, // Our values
	                backgroundColor: [ // Specify custom colors
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)',
	                    'rgba(77,119,197)'
	                ],
	                borderColor: [ // Add custom color borders
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)',
	                    'rgba(88,169,229)'
	                ],
	                borderWidth: 0.5 // Specify bar border width
	            }]
	        },
	        options: {
	            responsive: true, // Instruct chart js to respond nicely.
	            maintainAspectRatio: false, // Add to prevent default behaviour of full-width/height 
	        }
	    });
	    return myChart;
	}
 
 var surveyJson = [ {
		"averageScore":"4.5",
		"profit($)":"89",
		"turnover($)":"200",
		"question":"Q1"
	}, {
		"averageScore":"3.5",
		"profit($)":"225",
		"turnover($)":"550",
		"question":"Q2"
	},{
		"averageScore":"1.76",
		"profit($)":"600",
		"turnover($)":"1200",
		"question":"Q3"
	},{
		"averageScore":"4.56",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q4"
	},{
		"averageScore":"4.16",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q5"
	},{
		"averageScore":"3.56",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q6"
	},{
		"averageScore":"2.89",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q7"
	},{
		"averageScore":"3.58",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q8"
	},{
		"averageScore":"4.96",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q9"
	},{
		"averageScore":"3.96",
		"profit($)":"1100",
		"turnover($)":"2450",
		"question":"Q10"
	}];

	console.log(surveyJson);
	//Map json values back to label array
	var surveyLabels = surveyJson.map(function (e) {
	 return e.question;
	});
	console.log(surveyLabels);
	//Map json values back to values array
	var surveyValues = surveyJson.map(function (e) {
	 return e.averageScore;
	});
	console.log(surveyValues);	
 
 window.onload = function() {
 	console.log("THIS IS RUNNNNNN");
 	var chart = BuildChart(labels, values, "Average Score for each question");
 	var surveyChart = BuildSurveyChart(surveyLabels, surveyValues, "Average Score for each question");
 }