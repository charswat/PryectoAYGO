# PryectoAYGO

La aplicación requiere dar de alta a un usuario en una base de datos mongoDB mediante servicios web REST,contenedores Docker y  las solicitudes se disribuyan por el metodo roundRobin.Para ello se creo una interfaz web la cual recibe el nombre de un usuario, cuando se envia la solicitud se consume un servicio web de balanceo de cargas con el metodo RoundRobin, el cual asigna un puerto para consumir un backend especifico de los 3 expuestos mediante servicios web y que finalmente alimente la base de datos mongo,esta nos retornara el listado de los ultimos 10 usuarios creados junto con la fecha de creación.

1 Para el desarrollo  desarrollado el proyecto agregamos los archivos docker-compose.yml y Dockerfile a las raiz y los configuramos asi:
Backend:
 
![backend](https://user-images.githubusercontent.com/72947118/97713990-94428e00-1a8e-11eb-8b1a-0a1dee836a58.jpg)

![2](https://user-images.githubusercontent.com/72947118/97714003-97d61500-1a8e-11eb-8a7b-9a0c3a1fde4f.jpg)


Se recomienda eliminar el jar C:\Users\GOD\.m2\repository\org\mongodb\bson\2.12.2\bson-2.12.2.jar,para no obtener errores en aws

2 generamos las imágenes en docker con el comando docker-compose up –d .
![4](https://user-images.githubusercontent.com/72947118/97714914-bf79ad00-1a8f-11eb-8690-b69f561e89c5.jpg)
Para listar las imágenes credas realizar el comando docker ps
 ![4 1](https://user-images.githubusercontent.com/72947118/97714923-c3a5ca80-1a8f-11eb-9f40-7d16abbab714.jpg)

3.Despues de creadas localmente, creamos la referencia  de nuestros repositorios creados en github asi: 
docker tag balanceadorwebaygo_web charswat/balanceador 
docker tag balanceadorwebaygo_web charswat/backend
docker tag balanceadorwebaygo_web charswat/basedatos:3.6.1 

![5](https://user-images.githubusercontent.com/72947118/97715081-f3ed6900-1a8f-11eb-8513-7c457e127959.jpg)

4.Despues de creadas localmente, se envian las imagens a dockerHUb con los siguientes comandos  para ser desplegadas en Aws:
docker push dnielben/firstsprkwebapprepo:latest 
docker push charswat/balanceador 
docker push charswat/backend
docker push charswat/basedatos:3.6.1 


Cuando se envían a docker así quedan desplegadas las imágenes.
![6](https://user-images.githubusercontent.com/72947118/97715250-29925200-1a90-11eb-93c5-31aa5b02adcb.jpg)
 
5. Pasamos a crear la máquina virtual en aws(EC2).
 ![7](https://user-images.githubusercontent.com/72947118/97715269-2d25d900-1a90-11eb-969b-ee871ec1661d.jpg)
Maquina virtual creada con linux.
 
![8](https://user-images.githubusercontent.com/72947118/97715540-85f57180-1a90-11eb-9cad-3c027ecc3045.jpg)


6.Se instala docker
![9](https://user-images.githubusercontent.com/72947118/97715546-8857cb80-1a90-11eb-94bd-c153c05dfd7e.jpg)
 
7.Con el siguiente comando instala jdk 8:
   docker run amazoncorretto:8 java -version
8.Descargamos las 3 imágenes y creamos las instancias de ellas utilizando los siguientes comandos:
docker run -d -p 8087:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8088:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8089:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8090:8080 --name balanceador charswat/balanceador 
docker run -d -p 27017:27107 --name databasemongo charswat/basedatos:3.6.1

![10](https://user-images.githubusercontent.com/72947118/97715549-8b52bc00-1a90-11eb-87fc-6d174cb2965a.jpg)

Pruebas awz Backend
 ![11 1](https://user-images.githubusercontent.com/72947118/97715936-fac8ab80-1a90-11eb-91a0-213db70bbb98.jpg)
![11 2](https://user-images.githubusercontent.com/72947118/97715941-fbf9d880-1a90-11eb-94e7-e511fa2dcf14.jpg)
![11 3](https://user-images.githubusercontent.com/72947118/97715952-fe5c3280-1a90-11eb-9315-4765fcce7c4f.jpg)
 
Balanceador 
 
11eb-9315-4765fcce7c4f.jpg)
![12](https://user-images.githubusercontent.com/72947118/97715972-061bd700-1a91-11eb-9fab-261090273fba.jpg)

![12 1](https://user-images.githubusercontent.com/72947118/97715960-01572300-1a91-11eb-8e7c-d90566459890.jpg)
 

Cliente web finalmente me trae los últimos 10 registros.
 ![fin](https://user-images.githubusercontent.com/72947118/97716165-48451880-1a91-11eb-91a0-9f5926e8c721.jpg)

