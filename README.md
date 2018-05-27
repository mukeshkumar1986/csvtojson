# csvtojson


This sample converts the [CSV file](https://github.com/mukeshkumar1986/csvtojson/blob/master/src/main/resources/sample_csv.csv) into JSON like below
  
  ```
  [
     {
        "id":"1",
        "name":{
           "first":"Dan",
           "last":"Dan"
        },
        "rating":[
           8,
           7,
           9
        ]
     },
     {
        "id":"2",
        "name":{
           "first":"Bill",
           "last":"Bill"
        },
        "rating":[
           7,
           6,
           5
        ]
     },
     {
        "id":"3",
        "name":{
           "first":"Joe",
           "last":"Joe"
        },
        "rating":[
           4,
           3,
           null
        ]
     }
  ]
  ```