# AppTest

AppTest es una aplicación Android, diseñada para la búsqueda de negocios cercanos a tu ubicación, a traves del API de YELP ( https://www.yelp.com/developers/documentation/v3/get_started )

## Installation

Descargando nuestro archivo zip., de esta forma ya lo tendriamos en nuestro equipo, nos queda extraer nuestro proyecto de la carpeta zip.
De esta forma podremos abrir el proyecto a traves de andrpoid studio y correrla para su uso.


## Usage

De inicio el app nos depliega un fragment el cual cuenta con un SearchView y un boton, estos nos daran posibilidad de ingresar y buscar una palabra clave para 
la busqueda, almomento de comenzar la busqueda el app solicita permisos para el acceso a la ubicacion, al ser aceptados, obtiene la ubicacion del dispositivo 
para realizar una busqueda basado en tu ubicacion y la palabra clave, esto nos despliega una lista de negocios, al clickear alguno, nos envia a otro fragment 
que nos mostrara un mapa con la ubicacion del negocio asi como la del dispositivo de busqueda y la informacion del negocio.

## Implementaciones

se hace uso de librerias como 

```bash
  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
  implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'
  implementation 'com.github.bumptech.glide:glide:4.12.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
  implementation 'com.makeramen:roundedimageview:2.3.0'
  implementation "androidx.navigation:navigation-fragment:$nav_version"
  implementation "androidx.navigation:navigation-ui:$nav_version"
```
