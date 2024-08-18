Book Management App - Spring Web MVC, MySQL, Hibernate/JPA, Thymeleaf/HTML - pages: User registration page, login page, books display page with add, update, delete and logout buttons, save books page(bookmark)

Managed project dependencies in pom.xml using Maven. Created model entities and implemented Bean Validation with Hibernate Validator and Spring MVC validators to validate properties such as email using @NotEmpty and regex patterns. Used the @Valid annotation for method-level validation and defined error messages in the view using Thymeleaf tags.

Implemented a User table to store registered user information, including encoded passwords with PasswordEncoder to secure plain text passwords. Validated email on both the registration and login pages, ensuring that all fields were filled out correctly. Configured error messages for invalid passwords in the controller.

Added functionalities such as add, update, delete, and logout buttons on the books display page
