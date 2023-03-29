# Logoscope

Logoscope is a simple website that allows you to upload and download images stored in a SQL server database. It is built using Java and Servlet.

## Prerequisites

To run this project, you need to have the following installed:

- XAMPP
- Apache Tomcat 10
- MySQL
- Java Development Kit (JDK)
- Java Servlet API

## Installation

1. Clone this repository to your local machine.
2. Open XAMPP and start Apache and MySQL services.
3. Open phpMyAdmin and create a database named `logoscope`.
4. Import the `logoscope.sql` file from the repository to the database.
5. Copy the `logoscope` folder from the repository to the `webapps` folder of your Tomcat installation directory.
6. Open a terminal and navigate to the `bin` folder of your Tomcat installation directory.
7. Run the command `startup.bat` (Windows) or `startup.sh` (Linux) to start the Tomcat server.

## Usage

1. Open a browser and go to `http://localhost:8080/logoscope`.
2. You will see a simple interface with two buttons: Upload and Download.
3. To upload an image, click on the Upload button and choose an image file from your computer. The image will be uploaded to the database and you will see a confirmation message.
4. To download an image, click on the Download button and choose an image from the list of available images. The image will be downloaded to your computer and you will see a confirmation message.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
