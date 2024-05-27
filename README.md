Este es un pequeño proyecto para ver cómo generar plugins nativos de android en un proyecto React con Capacitor. En este ejemplo vamos a ver cómo navegar a una vista nativa desde una híbrida con JavaScript y viceversa. 

1. Primero ejecutamos "npx create-react-app react_capacitor_custom_native_plugin" para crear un proyecto React desde 0. Cabe destacar que este comando ya no se suele utilizar pero en nuestro caso, al tratarse de una prueba con fines de investigación, nos vale perfectamente.

2. Después ejecutamos "npm install @capacitor/core @capacitor/cli" en la carpeta generada por el anterior comando para añadir esas librerías.

3. Instalamos la dependencia android con "npm install @capacitor/android", inicializamos Capacitor con "npx cap init", y añadimos la plataforma android con "npx cap add android". Finalmente construimos con "npm run build" y sincronizamos con "npx cap sync". 

4. Debemos tener en cuenta que cada vez que hagamos cambios en el código tendremos que ejecutar después "npm run build", "npx cap sync" y "npx cap run android" para construir el proyecto, sincronizar con Capacitor y ejecutar en android.

5. Una vez hecha la instalación, abrimos el proyecto con el IDE de nuestra elección. Yo estoy usando WebStorm para la parte JS y Android Studio para la parte de java.

6. En Android Studio abrimos el directorio donde se encuentra MainActivity.java y creamos un nuevo fichero llamado CustomPlugin.java. La clase debe heredar de Plugin y debe tener la anotación @CapacitorPlugin(name = "CustomPlugin"). Los métodos que queramos poner en este plugin deben tener la anotación  @PluginMethod() y recibir por parámetros una PluginCall, que es la clase que envuelve la llamada de la capa web a la parte nativa.

7. En el mismo directorio creamos un nuevo fichero llamado NativeViewActivity.java y en android/app/app/src/res/layout creamos activity_native_view.xml. En el fichero xml ponemos un botón y en NativeViewActivity le asignamos la función finish() al evento de clic para cerrar la activity.

8. En CustomPlugin.java creamos un método "openNativeView" que genere un Intent para navegar a la activity NativeViewActivity.

9. En MainActivity sobreescribimos el método onCreate para registrar el plugin antes de hacer la llamada a super.onCreate().

10. A continuación nos vamos a la raíz del proyecto y de ahí a src/. Creamos un nuevo fichero llamado "PluginRegistration.js". Ahí importamos registerPlugin de @capacitor/core, registramos el plugin que hemos creado en CustomPlugin.java y lo exportamos.

11. Ahora en App.js importamos el plugin desde "./PluginRegistration" y ya podemos usarlo para llamar a sus métodos. En nuestro caso hemos asociado la función "openNativeView()" a un evento en un botón que se mostrará en la pantalla principal al ejecutar la aplicación.

12. Tras esto, vamos a AndroidManifest.xml y añadimos la nueva activity a la etiqueta aplication: "<activity android:name=".NativeViewActivity" />" 

13. Finalmente hacemos el build, sincronizamos, ejecutamos la aplicación en un dispositivo o emulador android y ya podemos navegar entre vistas React y vistas android nativas.
