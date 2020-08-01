A continuación, se describen los contenidos de cada carpeta:
- JavaApp:
	contiene la aplicación de administrador que permite modificar la base de datos y hacer consultas de interés para la empresa.
- WebApp:
	contiene los archivos para el servicio web que usaran los usuarios.
- SQL:
	- install_mariadb.bat:
		instala el servidor de base de datos con las credenciales necesarisas
		NOTA: la base de datos usada es MariaDB
		NOTA 2: si el archivo comunica algún error, entonces se debe instalar la base de datos con el archivo "mariadb.msi" con el usuario "root" y contraseña "admin"
	- load_db.bat:
		carga la base de datos inicial del archivo "db_backup_company.sql"
		NOTA: si el archivo comunica algun error, entonces se debe cargar la base de datos manualmente usando el archivo "db_backup_company.sql"
	- copy_db.bat:
		copia la base de datos en el archivo "db_backup_company.sql"
