echo "uploading data.txt to elasticsearch"
curl -s -XPOST localhost:9200/_bulk?pretty --data-binary "@data.txt"; echo

