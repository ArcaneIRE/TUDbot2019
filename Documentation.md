# ');DROP TABLE Teams;--

## SentryBot Introduction

>Quick note: Any time `SentryBot` is shown here as inline code, we are referring to the competition sentry that is in every game. Our Robot will be referred to as "our Robot" .

Originally, we didnt know much about the mechanics of Robocode or the specific circumstances of this tournament. From some small initial research, we planned to make a robot that would enter the danger zone of the `SentryBot` and use some complicated procedures to predict and dodge bullets from both the enemy and the `SentryBot`. After realising that we were only able to use the standard `Robot` class and not the `AdvancedRobot` class, we decided that all of this dodging and scanning wasted too many turns. Because we spawn so close to the enemy, we decided that the most efficient use of our turns was to simply ram them to claim ramming bonuses while firing whenever possible. So we settled on a ramming bot. We based our design on the ramming bot that comes with Robocode by default, `RamFire` by Mathew A. Nelson. After this it became a case of making sure our initial actions were as quick as possible and that we had a proper course of action when we get into a ramming loop.

## Design Overview

#### Pseudocode
```
Run
	Turn Radar Right until enemy is found. 
	
On Scanning a Robot
	Check if they're the sentryBot. Exit to run if they are.
	Turn to face them.
	SmartFire at them.
	Move towards them.
	Scan again to make check if they've moved.
	
On Ramming a Robot
	Turn to face them.
	SmartFire at them.
	Ram them.

SmartFire
	Check if we are able to fire, if so, fire.
	If not, return to Run.
```

#### Scanning
```java
while (true) {
	turnRadarRight(45 * turnDirection);
}//END WHILE
```
Because the different components of your Robot and the Robot itself have varying turn rates, we decided to turn the radar to scan and then turn the body once we find the enemy. It's turn rate is %450 faster than turning the entire Robot. In most scenarios this saves us at least one turn. We are able to very quickly find the enemy at the start of the round. Mikael came up with this improvement.

#### Avoiding the `SentryRobot`
```java
if (e.getEnergy() > 200) {
	return;
}//END IF
```
To ensure that we dont accidentally target the `SentryBot`, if we scan any robot, we check it's energy. Since the `SentryBot` has 500 energy and it can never be lowered, we check for a value far above what a normal robot can reach in a normal game. David added this when he figured out that checking the robot's name is not reliable as the enemy can fake it (as we have done). We had problems using Robocode's built in function so we used this.

#### SmartFire
```java
public int smartFire() {
	if (getGunHeat() == 0) {
		fire(3);
		return 1;
	} else {
		return 0;
	}//END IF ELSE
}
```
To ensure no turns are wasted with `fire()` calls while we have an overheated gun, we developed this *very intelligent* function to use instead of the standard `fire()`. Richard thought of this and David implemented it.
