until mongo "mongodb://user:password@mongodb" --eval "print(\"waited for connection\")"
do
    sleep 1
done

echo "Applying replication setup"
mongo "mongodb://user:password@mongodb" --eval "rs.initiate({  _id : \"rs0\", members: [{ _id: 0, host: \"mongodb:27017\" }] });"
echo "Replication setup"
echo "Creating DB"
mongo "mongodb://user:password@mongodb" --eval "use inshur-example | db.createCollection("policy")"