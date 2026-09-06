# Order Approval Workflow

## Overview

This project implements an Order Approval Workflow using Java 17.

## Order States

- DRAFT
- CONFIRMED
- PAID
- CANCELLED

## Business Rules

- An order must contain at least one line before confirmation.
- Quantity must be a positive whole number.
- A cancelled order cannot be paid.
- A paid order cannot return to draft.
- Order total is calculated from line prices and quantities.

## Architecture

The domain is implemented using plain Java and is independent of Spring, JPA, HTTP and database adapters.

Ports and adapters are used to keep external systems separate from the domain.

## Testing

JUnit tests are included to verify the main order business rules.
