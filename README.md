# Quiz Jump

An educational platformer, modified from the [Jump and Run Demo w/Moving Platform](https://www.greenfoot.org/scenarios/11302) scenario from the Greenfoot scenario gallery, built for an AP CSA educational game project.

## Concept

A question shows at the top of the screen. Three floating platforms appear, each labeled with a possible answer, one correct, the rest wrong. Jump onto the correct platform to score a point and advance to the next question. Landing on a wrong platform, touching the patrolling enemy, or running out the per-question timer all cost a life. Lose all 3 lives and it's game over, with a score summary and the option to restart on the up arrow.

## Controls

- **Left / Right arrow keys** — move
- **Space bar** — jump (only while standing on solid ground or a platform)
- **Up arrow** — restart after game over

## Visuals

Sprites are from Kenney's [Pixel Platformer](https://kenney.nl/assets/pixel-platformer) asset pack (CC0 1.0, public domain, free for any use including commercial), sourced via the [uheartbeast/Pixel-Platformer](https://github.com/uheartbeast/Pixel-Platformer) mirror. Ground and answer platforms are built by tiling the grass/dirt block sprite; the player is Kenney's astronaut character; the Hazard enemy is Kenney's angry block-face character; lives in the HUD are drawn as heart sprites. No copyrighted or trademarked character art (e.g. Nintendo's Mario) is used anywhere in this project.

## Features

- Gravity and jump physics, landing detection against both the ground and the answer platforms
- A patrolling Hazard enemy that costs a life on contact
- A per-question countdown timer (green to yellow to red)
- A streak bonus for consecutive correct answers
- A level system: correct answers raise the level, which pushes the platforms higher and harder to reach
- Game over and restart flow with a running high score
- A dedicated, correctly centered game-over overlay, separate from the HUD bar

## CodeAcademy Java topics used

- **Access / Encapsulation** — `Player`'s `score`, `lives`, `streak`, and `velocityY` fields are private, only reachable through methods like `correctHit()`, `miss()`, and getters.
- **Static methods** — `QuestionBank` is a static class holding the shared pool of questions; every round pulls from the same static source via `QuestionBank.getCurrentQuestion()`.
- **Inheritance / Polymorphism** — `CorrectAnswerPlatform` and `WrongAnswerPlatform` both extend the abstract `AnswerPlatform` class, overriding `onLanded()` differently depending on which one the player jumps onto.

## Project structure

All visuals (player, platforms, hazard, HUD) are drawn directly in code with `GreenfootImage`, so there are no external image or sound assets required to run this scenario.

## How to run

1. Download or clone this repository
2. Open the folder in Greenfoot (`Scenario -> Open`)
3. Compile
4. Right-click `PlatformerWorld` -> `new PlatformerWorld()`, then click Run
