#!/bin/bash
curl 'https://oapi.dingtalk.com/robot/send?access_token=bd1124386fa17ac91e9f8386d59d98a2dd199746f200c6be07b4c6303e0f85e1' \
   -H 'Content-Type: application/json' \
   -d '
  {"msgtype": "text",
    "text": {
        "content": "我就是我, 是不一样的烟火"
     },
     "at": {
         "atMobiles": [
             "17602176634"
         ],
         "isAtAll": false
     }
  }'