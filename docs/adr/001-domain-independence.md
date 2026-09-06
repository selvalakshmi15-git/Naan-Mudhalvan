# ADR 001: Keep the Domain Independent

## Status

Accepted

## Context

The Order domain should not depend on Spring, JPA, HTTP, or database adapters.

## Decision

The domain contains the core Order business rules and uses plain Java.

External systems are connected through ports and adapters.

## Consequences

The domain can be tested independently.

The application can change database or framework without changing the core Order rules.
