apiVersion: apps/v1
kind: Deployment
metadata:
  name: redisCaller 
  labels:
    app: redisCaller
spec:
  replicas: 2
  selector:
    matchLabels:
      app: redisCaller
  template:
    metadata:
      labels:
        app: redisCaller
    spec:
      hostname: redisCaller
      subdomain: default-subdomain
      containers:
      - name: redisCaller
        image: kulkarniadwait44/redisCaller:1.0.0
        imagePullPolicy: Always
        ports:
        - containerPort: 8085
---
apiVersion: v1
kind: Service
metadata:
  name: redisCaller-svc
spec:
  type: NodePort
  selector:
    app: redisCaller
  ports:
  - name: default
    protocol: TCP
    port: 8085
    targetPort: 8085