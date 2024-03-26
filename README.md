# Simplified Transfer

## Objective
Develop a money transfer system between common users and shopkeepers, ensuring the integrity of information and transaction security. This project was followed through the video 'https://www.youtube.com/watch?v=QXunBiLq2SM&ab_channel=FernandaKipper%7CDev', with some modifications, with the intention of learning more about Spring Boot Rest Full.

## Requirements
- User registration with Full Name, CPF, Email, and Password.
- Validation of unique CPF/CNPJ and emails in the system.
- Transfers between users with balance verification.
- Consultation to an external authorization service before finalizing transactions.
- Handling transfers as reversible transactions. 
- Notification of payment receipt to users or shopkeepers.

## API RESTful
- **POST** /transaction
  - **json**
  ```json
  {
  	"value": 30,
  	"senderId":9,
  	"receiverId":10
  }

## External Services (Mocks)
Notification Service: https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6

# Configuration

- Clone the repository: `https://github.com/KarMiguel/Transferred-values-between-type.git`
- Install dependencies: `npm install` or `yarn install`
- Run the project: `npm start` or `yarn start`
- The server will be running at `http://localhost:8091`
- Make sure to configure the necessary environment variables, such as external service URLs, API keys, etc.

# Contribution

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/MyFeature`)
3. Commit your changes (`git commit -am 'Adding a new feature'`)
4. Push to the branch (`git push origin feature/MyFeature`)
5. Open a Pull Request
