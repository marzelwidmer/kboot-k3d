# README

## K3d

```bash
k3d cluster create --config k8s/k3d/k3d-config.yaml
```

```bash
k3d cluster list
```

```bash
k3d cluster delete dev
```

### Install Infra

```bash
kubectl get nodes
```

```bash
kubectl apply -f k8s/k3d/infra/
```

There are the following files includes :

- ingress.yaml (traefik)
- service-account.yaml (read config map etc with kubernetes spring library)
- spring-encrypt.yaml (secret file used from the application)
- pvc (persistent volume claim)
- pv (persistent volume)

## Skaffold deploy application

```bash
skaffold run -p k3d --tail
```

## Test Application

- [http://localhost/actuator/health](http://localhost/actuator/health)
- [http://localhost/api/application/config](http://localhost/api/application/config)
    
```bash
http http://localhost/api/application/config
``` 

# Some Traefik insides

## Expose dashboard

check that deployments are finished

```bash
kubectl --namespace kube-system get deployments/traefik -w
```

```bash
kubectl --namespace kube-system port-forward deployments/traefik 9000:9000 &
```

[http://localhost:9000/dashboard/#/](http://localhost:9000/dashboard/#/)

```bash

```

[k3d exposing service via ingress](https://k3d.io/v5.6.0/usage/exposing_services/#1-via-ingress-recommended)

## create a cluster, mapping the ingress port 80 to localhost:8081

```bash
k3d cluster create --api-port 6550 -p "8081:80@loadbalancer" --agents 2
```

## create a nginx deployment

```bash
kubectl create deployment nginx --image=nginx
```

## create a ClusterIP service for it

```bash
kubectl create service clusterip nginx --tcp=80:80
```

## create an ingress object

```bash
kubectl apply -f k8s/k3d/infra/thatfile.yaml
```

## call service (curl)

```bash
curl localhost:8081/
```

# k8s Knoff Hoff
Search all in AppGroup demo
```bash
kubectl get sts,pvc,svc,netpol,svc,po,configmaps,deployments,secrets -l 'appGroup in (demo)'
```

Delete all in AppGroup demo
```bash
kubectl delete sts,pvc,svc,netpol,svc,po,configmaps,deployments,secrets -l 'appGroup in (demo)'
```
