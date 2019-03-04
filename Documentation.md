# ');DROP TABLE Teams;--

## SentryBot Introduction

Originally, we didnt know much about the mechanics of Robocode or the specific circumstances of this tournament. From some small initial research, we planned to make a robot that would enter the danger zone of the `SentryBot` and use some complicated procedures to predict and dodge bullets from both the enemy and the `SentryBot`. After realising that we were only able to use the standard `Robot` class and not the `AdvancedRobot` class, we decided that all of this dodging and scanning wasted too many turns. Because we spawn so close to the enemy, we decided that the most efficient use of our turns was to simply ram them while firing whenever possible. So we setlled on a ramming bot. After this it became a case of making sure our initial actions were as quick as possible and that we had a proper course of action when we get into a ramming loop.

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
To ensure no turns are wasted with `fire()` calls while we have an overheated gun, we developed this *very intelligent* function to use instead of the standard `fire()`.

#### Scanning
```java
while (true) {
	turnRadarRight(45 * turnDirection);
}//END WHILE
```
Because the different components of your Robot and the Robot itself have varying turn rates, we decided to turn the radar to scan and then turn the body once we find the enemy. It's turn rate is %450 faster than turning the entire Robot. In most scenarios this saves us at least one turn. We are able to very quickly find the enemy at the start of the round.
