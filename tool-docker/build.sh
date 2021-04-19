IMAGE_NAME=xxx
CONTAINER_NAME=xxx

# 清理 Docker container
docker rm -f $CONTAINER_NAME

# 清理 Docker images
docker rmi $IMAGE_NAME

# 通过文件构建 Image
docker build -t $IMAGE_NAME .

# 启动 Image container
docker run --name $CONTAINER_NAME -p HOST_PORT:CONTAINER_PORT --restart=always -d IMAGE_NAME
