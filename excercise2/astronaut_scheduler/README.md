# Astronaut Daily Schedule Organizer

Console-based Java application to help astronauts organize daily schedules.

## Features
- Add, remove, and view tasks (CRUD)
- Tasks have description, start time, end time, and priority
- Prevents overlapping tasks (Observer pattern for conflicts)
- Singleton `ScheduleManager`
- Factory `TaskFactory` for creating validated tasks
- Optional: filter tasks by priority, mark as completed

## Design Patterns
- **Singleton** → ScheduleManager
- **Factory** → TaskFactory
- **Observer** → ConflictObserver

## Run Instructions
```bash
javac Main.java model/*.java manager/*.java
java Main
```
