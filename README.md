# driver-api

# Simple Project to test resilience patterns with Resilience4j

>[!TIP]
>Check branchs to see new implementations


## 2 mocked APIs called with FeignClient

1. **MockApi GET /hello**
    1. Check for ```/resources/open-api-mocks/api.yaml```
    2. Check also ```docker-compose.yaml``` for the **image: stoplight/prism:4**
    3. ```GET /hello -> { message: "Hello World" }``` 
      
2. **DelayApi GET /delay/{delay}**
   1. Just pass de **delay param** and the api will respond after that time in milliseconds
   2. Check also ```docker-compose.yaml``` for the **image: ffnunes/delay-api:2.0.0**
   3. ```GET /delay/500 -> waits 0.5s -> { message: "Hello World" }```
   4. ```GET /delay/2000 -> waits 2s -> { message: "Hello World" }```


## Using k6
<hr/>

### Install k6
https://grafana.com/docs/k6/latest/set-up/install-k6/
<hr/>

### Examples using k6 for stress test

```k6 run --duration 10s ./src/test/k6/create-driver-k6-test.js```

```k6 run --duration 10s --vus 2 ./src/test/k6/create-driver-k6-test.js```
