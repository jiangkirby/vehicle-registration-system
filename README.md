# Vehicle Registration System

## Table of Contents

- [Description](#description)
- [Features](#features)

## Description

The Vehicle Registration System is a simple Java application that allows users to register different types of vehicles and manage their ownership details in various jurisdictions. The system supports three types of vehicles: motorcycles, automobiles, and boats. It provides functionality to create vehicles, register them in specific jurisdictions, calculate excise tax based on jurisdiction rules, and retrieve registration information through filtering.

## Features

- Vehicle Registration: Allows users to register new vehicles with details such as make, production year, purchase price, and maximum passenger capacity.
- Multi-jurisdiction Support: The system supports multiple jurisdictions, each with its own excise tax calculation rules.
- Owner Management: The system maintains ownership details for each vehicle, including the name and address of the owners.
- Singleton Design: The RegistrationSystem class is implemented as a Singleton to ensure only one instance of the system exists throughout the application's lifecycle.
- Error Handling: The system enforces various validation checks to ensure data integrity. It throws appropriate exceptions for invalid inputs.
- Registration Filtering: Provides the capability to filter registrations based on custom criteria using the Predicate interface.
- Reboot Functionality: The system can be reset to its initial state, clearing all existing registrations and data.
- Unmodifiable Lists: All retrieval methods return unmodifiable lists to ensure data consistency and prevent unwanted modifications.