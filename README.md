# Proyecto Final Supermercado

El proyecto tiene el objetivo de aplicar lo que se ha aprendido en el curso programacion web 2020

## Informacion del Proyecto 🚀

En el Proyecto Supermercado se aplico:
Base de Datos
JDBC
Git
Servlets
JSP.


### Requisitos usados en el proyecto 📋

Principalmente los programas utilizados: Apache NetBeans IDE 11.3
MySQL Workbench 8.0 CE en donde se use el siguient tipo de conexion

```
private static DataSource getDataSource(){
         if(dataSource==null){
            dataSource=new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername(" ";
            dataSource.setPassword(" ");
            dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
            dataSource.setInitialSize(20);
            dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
            dataSource.setMaxWaitMillis(5000);
        
        }
        return dataSource;
    
    }Da un ejemplo
```

### Desarrolo del proyecto

Utilizando principal servlet ProductoController para la conexion de clases.java y jsp
```
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
}
```


```
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
}
```


## Informacion para Ejecutar Programa

principalmente genera un pequeño menu de ingreso de producto y mostrar los productos,
la cual en cada fila de cada producto el codigo que genera automaticamente dara un link para poder modificarlo
como tambien en la parte derecha mostrara la opcion de eliminar el producto.



## IDE 11.3

Se uso para crear este proyecto la siguiente herramienta
* [Maven](https://maven.apache.org/) - la cual es un manejador de dependencias


## Link del Repositorio

 [repositorio](https://github.com/).

## Autor ✒️


* **Aniver Alonzo** - *Estudiante de programacion web 2020*

