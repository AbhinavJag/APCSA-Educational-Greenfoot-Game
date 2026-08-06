# Quiz Invaders

An educational modification of the [Space Invaders Game](https://www.greenfoot.org/scenarios/30925) scenario from the Greenfoot scenario gallery, built for an AP CSA educational game project.

## Concept

Instead of shooting generic aliens, the player shoots falling "answer invaders." Each round shows one question at the top of the screen, and a set of invaders falls carrying possible answers (one correct, the rest wrong). Shooting the correct answer scores a point and moves to the next question. Shooting a wrong answer, or letting the correct one fall past the bottom, costs a life. The game ends after 3 lives are lost.

## Controls

- **Left / Right arrow keys** — move the ship
- **Space bar** — fire

## CodeAcademy Java topics used

- **Access / Encapsulation** — `Ship`'s `score` and `lives` fields are private, only reachable through `addScore()`, `loseLife()`, and getters.
- **Static methods** — `QuestionBank` is a static class holding the shared pool of questions; every invader that spawns pulls from the same static source via `QuestionBank.getCurrentQuestion()`.
- **Inheritance / Polymorphism** — `CorrectAnswerInvader` and `WrongAnswerInvader` both extend the abstract `AnswerInvader` class, overriding `handleHit()` and `handleMissed()` differently depending on which one they are.

## Project structure

All visuals (ship, invaders, bullets, HUD) are drawn directly in code with `GreenfootImage`, so there are no external image or sound assets required to run this scenario.

## How to run

1. Download or clone this repository
2. Open the folder in Greenfoot (`Scenario -> Open`)
3. Compile
4. Right-click `QuizWorld` -> `new QuizWorld()`, then click Run
