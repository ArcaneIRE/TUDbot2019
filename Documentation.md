# ');DROP TABLE Teams;--

## SentryBot

	Originally, we didnt know much about the mechanics of Robocode or the specific circumstances of this tournament. From some small initial research, we planned to make a robot that would enter the danger zone of the `SentryBot` and use some complicated procedures to predict and dodge bullets from both the enemy and the `SentryBot`. After realising that we were only able to use the standard `Robot` class and not the `AdvancedRobot` class, we decided that all of this dodging and scanning wasted too many turns. Because we spawn so close to the enemy, we decided that the most efficient use of our turns was to simply ram them while firing whenever possible. After this it became a case of making sure our initial actions were as quick as possible and that we had a proper course of action when we get into a ramming loop.

###SmartFire
