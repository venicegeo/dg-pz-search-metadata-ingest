package piazza.services.ingest;

curl -XPOST https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/locationPointtt -d'{ "dataId": "Alfred E. Newman", "dataType": { "id": "findme", "type": "wfs", "url": "http://geoserver.dev:8080/geoserver/wfs", "featureType": "piazza:shelters", "version": "1.0.0" }, "metadata": { "name": "My Test Shapefile", "availability": "nope", "description": "This is a test.", "classType": "unclassified", "numericKeyValueList": [ { "key": "velocity", "value": 55.5 }, { "key": "angle", "value": 90 } ], "textKeyValueList": [ { "key": "comment", "value": "testing 1.. 2.. 3.." } ] }, "spatialMetadata": { "epsgCode": 1984 } }'

curl -XPOST https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/locationPointtt -d'{ "dataId": "Alfred E. Newman", "dataType": { "id": "PatrickUUID", "type": "wfs", "url": "http://geoserver.dev:8080/geoserver/wfs", "featureType": "piazza:shelters", "version": "1.0.0" }, "metadata": { "name": "London", "availability": "nope", "description": "London BBOX combined with random WFS; hmmm.", "classType": "unclassified", "numericKeyValueList": [ { "key": "velocity", "value": 55.5 }, { "key": "angle", "value": 90 } ], "textKeyValueList": [ { "key": "comment", "value": "I wanted a pony, but my parents got me a kitten!! %^&*%!!" } ] }, "spatialMetadata": { "epsgCode": 1984, "minY": 51.28, "maxY": 51.69, "minX": -0.51, "maxX": 0.334 } }'

curl -XPOST http://pz-search-metadata-ingest.cf.piazzageo.io/api/v1/data -d'{ "dataId": "Alfred E. Newman", "dataType": { "id": "findme", "type": "wfs", "url": "http://geoserver.dev:8080/geoserver/wfs", "featureType": "piazza:shelters", "version": "1.0.0" }, "metadata": { "name": "My Test Shapefile", "availability": "nope", "description": "This is a test.", "classType": "unclassified", "numericKeyValueList": [ { "key": "velocity", "value": 55.5 }, { "key": "angle", "value": 90 } ], "textKeyValueList": [ { "key": "comment", "value": "testing 1.. 2.. 3.." } ] }, "spatialMetadata": { "epsgCode": 1984 } }'

curl --data '{ "dataId": "Alfred E. Newman", "dataType": { "id": "findme", "type": "wfs", "url": "http://geoserver.dev:8080/geoserver/wfs", "featureType": "piazza:shelters", "version": "1.0.0" }, "metadata": { "name": "My Test Shapefile", "availability": "nope", "description": "This is a test.", "classType": "unclassified", "numericKeyValueList": [ { "key": "velocity", "value": 55.5 }, { "key": "angle", "value": 90 } ], "textKeyValueList": [ { "key": "comment", "value": "testing 1.. 2.. 3.." } ] }, "spatialMetadata": { "epsgCode": 1984 } }' http://pz-search-metadata-ingest.cf.piazzageo.io/api/v1/data

curl -XPOST 'http://pz-search-metadata-ingest.cf.piazzageo.io/api/v1/data?payload={ "dataId": "Alfred E. Newman", "dataType": { "id": "PatrickUUID", "type": "wfs", "url": "http://geoserver.dev:8080/geoserver/wfs", "featureType": "piazza:shelters", "version": "1.0.0" }, "metadata": { "name": "London", "availability": "nope", "description": "London BBOX combined with random WFS; hmmm.", "classType": "unclassified", "numericKeyValueList": [ { "key": "velocity", "value": 55.5 }, { "key": "angle", "value": 90 } ], "textKeyValueList": [ { "key": "comment", "value": "I wanted a pony, but my parents got me a kitten!! %^&*%!!" } ] }, "spatialMetadata": { "epsgCode": 1984, "minY": 51.28, "maxY": 51.69, "minX": -0.51, "maxX": 0.334 } }'


curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
          "matchAll" : {}
       }
  }'
  
 
curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d ' 
{ 
   "query" : { "match" : { "id" : "PatrickUUID" } } 
}'
 
curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "dataId" : "Alfred E. Newman"
          }
       }
  }'
  
  curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "comment" : "kitten"
          }
       }
  }'
  
curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "_all" : "kitten"
          }
       }
  }'
  
  curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "_all" : "kiten"
          }
       }
  }'  
  
  
  
curl -XGET 'http://ec2-54-175-229-24.compute-1.amazonaws.com:9200/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "_all" : "kitten"
          }
       }
  }'
  
  curl -XGET 'http://ec2-54-175-229-24.compute-1.amazonaws.com:9200/pzmetadata/_search?pretty=true' -d '
  {
      "query" : {
         "match" : {
             "_all" : "kiten"
          }
       }
  }'  
  
  
  
  
  
  
  curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
     "query" : {
        "fuzzy_like_this" : {
          "like_text" : "text like this one"
        }
     }
  }'
  
  curl -XGET 'https://search-venice-es-pjebjkdaueu2gukocyccj4r5m4.us-east-1.es.amazonaws.com/pzmetadata/_search?pretty=true' -d '
  {
     "query" : {
        "fuzzy_like_this" : {
          "like_text" : "kiten"
        }
     }
  }'
  
  

{
    "dataId": "Alfred E. Newman",
    "dataType": {
       "id": "findme",
        "type": "wfs",
        "url": "http://geoserver.dev:8080/geoserver/wfs",
        "featureType": "piazza:shelters",
        "version": "1.0.0"
    },
    "metadata": {
        "name": "My Test Shapefile",
        "availability": "nope",
        "description": "This is a test.",
        "classType": "unclassified",
       "numericKeyValueList": [
         {
           "key": "velocity",
           "value": 55.5
         },
         {
           "key": "angle",
           "value": 90
         }
       ],
       "textKeyValueList": [
         {
           "key": "comment",
           "value": "testing 1.. 2.. 3.."
         }
       ]
    },
    "spatialMetadata": {
        "epsgCode": 1984
    }
}

{
    "dataId": "Alfred E. Newman",
    "dataType": {
       "id": "PatrickUUID",
        "type": "wfs",
        "url": "http://geoserver.dev:8080/geoserver/wfs",
        "featureType": "piazza:shelters",
        "version": "1.0.0"
    },
    "metadata": {
        "name": "London",
        "availability": "nope",
        "description": "London BBOX combined with random WFS; hmmm.",
        "classType": "unclassified",
       "numericKeyValueList": [
         {
           "key": "velocity",
           "value": 55.5
         },
         {
           "key": "angle",
           "value": 90
         }
       ],
       "textKeyValueList": [
         {
           "key": "comment",
           "value": "I wanted a pony, but my parents got me a kitten!! %^&*%!!"
         }
       ]
    },
    "spatialMetadata": {
        "epsgCode": 1984,
        "minY": 51.28,
        "maxY": 51.69,
        "minX": -0.51,
        "maxX": 0.334
    }
}

//**** below is obsolete for reference

{
   "userId": "Alfred E. Newman",
   "date": "2014-09-15",
   "classification": "Secret",

    "numericKeyValue": [
      {
        "key": "velocity",
        "value": 55.5
      },
      {
        "key": "angle",
        "value": 90
      }
    ],
    "textKeyValue": [
      {
        "key": "comment",
        "value": "testing 1.. 2.. 3.."
      }
    ],

   "spatialMetadata": {
      "coordinateReferenceSystem": "WGS_1984",
      "epsgCode": 1984,
      "bboxBottomLeft": {"lat": "51.2867602", "lon": "-0.5103751"},
      "bboxTopRight": {"lat": "51.6918741", "lon": "0.3340155"},
      "locationName": "London",
      "locationCenterPoint": {"lat": "40", "lon": "-170"},
      "searchRadius": 20
   },
   "comment": "explicit comment testing 1.. 2.. 3.."
}

//**** below is obsolete for reference

{
    "dataId": "Alfred E. Newman",
    "dataType": {
        "type": "wfs",
        "url": "http://geoserver.dev:8080/geoserver/wfs",
        "featureType": "piazza:shelters",
        "version": "1.0.0"
    },
    "metadata": {
        "name": "My Test Shapefile",
        "availability": "nope",
        "description": "This is a test.",
        "classType": "unclassified",
       "numericKeyValueList": [
         {
           "key": "velocity",
           "value": 55.5
         },
         {
           "key": "angle",
           "value": 90
         }
       ],
       "textKeyValueList": [
         {
           "key": "comment",
           "value": "testing 1.. 2.. 3.."
         }
       ]
    },
    "spatialMetadata": {
        "epsgCode": 1984
    }
}
