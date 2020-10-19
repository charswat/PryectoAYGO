# PryectoAYGO

La aplicación requiere dar de alta a un usuario en una base de datos mongoDB mediante servicios web REST,contenedores Docker y  las solicitudes se disribuyan por el metodo roundRobin.Para ello se creo una interfaz web la cual recibe el nombre de un usuario, cuando se envia la solicitud se consume un servicio web de balanceo de cargas con el metodo RoundRobin, el cual asigna un puerto para consumir un backend especifico de los 3 expuestos mediante servicios web y que finalmente alimente la base de datos mongo,esta nos retornara el listado de los ultimos 10 usuarios creados junto con la fecha de creación.

1 Para el desarrollo  desarrollado el proyecto agregamos los archivos docker-compose.yml y Dockerfile a las raiz y los configuramos asi:
Backend:
 


 
Balanceo de cargas:
 
 
Se recomienda eliminar el jar C:\Users\GOD\.m2\repository\org\mongodb\bson\2.12.2\bson-2.12.2.jar,para no obtener errores en aws

2 generamos las imágenes en docker con el comando docker-compose up –d .
 

Para listar las imágenes credas realizar el comando docker ps
 

3.Despues de creadas localmente, creamos la referencia  de nuestros repositorios creados en github asi: 
docker tag balanceadorwebaygo_web charswat/balanceador 
docker tag balanceadorwebaygo_web charswat/backend
docker tag balanceadorwebaygo_web charswat/basedatos:3.6.1 

 

4.Despues de creadas localmente, se envian las imagens a dockerHUb con los siguientes comandos  para ser desplegadas en Aws:
docker push dnielben/firstsprkwebapprepo:latest 
docker push charswat/balanceador 
docker push charswat/backend
docker push charswat/basedatos:3.6.1 


Cuando se envían a docker así quedan desplegadas las imágenes.
 
5. Pasamos a crear la máquina virtual en aws(EC2).
 
Maquina virtual creada con linux.
 



6.Se instala docker
 
7.Con el siguiente comando instala jdk 8:
   docker run amazoncorretto:8 java -version
8.Descargamos las 3 imágenes y creamos las instancias de ellas utilizando los siguientes comandos:
docker run -d -p 8087:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8088:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8089:4567 --name ServiceBacked1 charswat/backend 
docker run -d -p 8090:8080 --name balanceador charswat/balanceador 
docker run -d -p 27017:27107 --name databasemongo charswat/basedatos:3.6.1

 

Pruebas awz Backend
 
 
 

Balanceador 
 

 

Cliente web finalmente me trae los últimos 10 registros.
 

