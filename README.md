# HospitalApp

##Look into master branch

Our hospital patient interface is a web application that allows users to register, log in, and manage appointments, doctors, and patients. We built the backend of the application using Java, and the frontend using Angular, HTML, and CSS. The database we used is PostgreSQL, which stores user, appointment, doctor, and patient information securely.

To ensure the security of the application, we used Spring Security for authentication and authorization purposes. Users can register with a unique username, email ID, name, mobile number, age, and password. After registering, they can log in and select an appointment date, timing, doctor name, and disease. We automatically fetch the doctor's specialty based on the selected doctor name.

In the doctor's section, doctors can add a description of their checkup and charges for the treatment. This information is then sent to the admin for review. In the admin section, the admin can see a list of all doctors and patients. In the patient list, the admin can see who has completed their treatment, who is currently under treatment, and who has been discharged. The admin can also view and manage doctor and patient information.

At the end of the patient table, there is a pay bill column with a pay button. The pay button is disabled if there is no description of the treatment provided by the doctor or if the charges for the treatment have not been added. Additionally, the pay button is not visible for discharged patients.

We implemented validations throughout the application to ensure that only valid and accurate data is entered. The application validates user input in the registration form, login form, appointment selection, and other sections where applicable.

Overall, our hospital patient interface is a secure and user-friendly web application that allows users to manage appointments, doctors, and patients. We designed the application to be secure, reliable, and intuitive, and we hope that it will provide a valuable service to all who use it.
