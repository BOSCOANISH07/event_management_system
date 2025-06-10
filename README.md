# Setup Guide for NetBeans IDE 8.2, JDK 1.8, and XAMPP

Follow these steps to set up and run the application:

## Prerequisites
Ensure you have the following installed on your system:
- **NetBeans IDE 8.2**
- **JDK 1.8**
- **XAMPP** (for MySQL database)

## Installation Steps

1. **Download the Project Files**
   - Download the provided project files as a `.zip` archive.

2. **Extract Files**
   - Unzip the downloaded archive.
   - Copy the extracted folder into the NetBeans project directory.

3. **Set Up NetBeans**
   - Open **NetBeans IDE 8.2**.
   - Navigate to **File > Open Project**.
   - Select the extracted project folder and click **Open**.

4. **Install XAMPP and Import Database**
   - Download and install **XAMPP**.
   - Open **XAMPP Control Panel** and start the **Apache** and **MySQL** services.
   - Open **phpMyAdmin** by navigating to `http://localhost/phpmyadmin/`.
   - Create a new database.
   - Import the `.sql` file from the project directory using the **Import** option.

5. **Configure Database Connection (if necessary)**
   - Open the project's database configuration file.
   - Ensure the database credentials (host, username, password, and database name) match those in phpMyAdmin.

6. **Run the Application**
   - In NetBeans, right-click the project and select **Run**.
   - The application should now be accessible via a local server.

