# Feature: NCAA Football Scoring

This feature describes how a team can score points according to the rules of NCAA football. There are two teams playing football: Team A is always the team on offense or the team initially possessing the football, and Team B is always the team on defense. Scores will be shown as "a" - "b" with the first value being a positive integer correlating to the score of Team A and the second value also as a positive integer which is the score for Team B. 

## Scenario: Running Touchdown Score
Given the score is 0 - 0 \
And a player from Team A is carrying a live ball \
And the ball penetrates the plane of the goal line of Team B \
And there is no penalty on the play \
Then the score is 6 - 0

## Scenario: Throwing Touchdown Score
Given the score is 0 - 0 \
And a player from Team A catches a forward pass \
And the player succesfully and legally completes the catch \
And the player is located in the end zone of Team B \
And there is no penalty on the play \
Then the score is 6 - 0

## Scenario: Fumble Recovery Touchdown Score
Given the score is 0 - 0 \
And a player from Team A fumbles the ball or throws a backwards pass \
And the ball is recovered, caught or intercepted by a player from Team B \
And the player from Team B possessing the ball breaks the plane of Team A's endzone \
And there is no penalty on the play \
Then the score is 0 - 6

## Scenario: Kick Recovery Touchdown Score
Given the score is 0 - 0 \
And Team A is executing a free kick \
And a player from Team A catches or recovers the kick \
And the player from Team A possessing the ball breaks the plane of Team B's endzone \
And there is no penalty on the play \
Then the score is 6 - 0

## Scenario: Referee Awards Touchdown Score
Given the score is 0 - 0 \
And a player from Team B commits an unsportsmanlike conduct foul \
And a referee decides it is equitable to award a score \
Then the score is 6 - 0

## Scenario: Field Goal Score
Given the score is 0 - 0 \
And a player from Team A is either drop or place kicking the ball \
And the ball passes over the crossbar and between the uprights of Team B's goal \
And the ball after it is kicked does not touch either the ground or a player from Team B \
And there is no penalty on the play \
Then the score is 3 - 0

## Scenario: Safety Score
Given the score is 0 - 0 \
And the ball is in the possession of a player from Team A \
And the player in possession of the ball is located in Team A's endzone \
And the ball becomes dead \
And there is no penalty on the play \
Then the score is 0 - 2

## Scenario: Running Touchdown Try
Given the score is 6 - 0 \
And Team A has just scored a touchdown \
And the teams proceed as described in the Running Touchdown Score Scenario \
Then the score is 8 - 0

## Scenario: Throwing Touchdown Try
Given the score is 6 - 0 \
And Team A has just scored a touchdown \
And the teams proceed as described in the Throwing Touchdown Score Scenario \
Then the score is 8 - 0

## Scenario: Field Goal Try
Given the score is 6 - 0 \
And Team A has just scored a touchdown \
And the teams proceed as described in the Field Goal Score Scenario \
Then the score is 7 - 0

## Scenario: Safety Try
Given the score is 6 - 0 \
And Team A has just scored a touchdown \
And the teams proceed as described in the Safety Score Scenario \
Then the score is 6 - 1

## Scenario: Forfeit Scores Tied
Given the score is 0 - 0 \
And Team B forfeits the game \
Then the score is 1 - 0

# Feature: NCAA Football End Game
This feature describes how a game of NCAA football can end according to the rules of NCAA football. There are two teams playing football: Team A is the first team or the winning team and Team B is the second team or the losing team. Scores will be shown as "a" - "b" with the first value being a positive integer correlating to the score of Team A and the second value also being a positive integer which is the score for Team B. The shown score will be the final score of the game and the end result.

## Scenario: One Team has More Points
Given Team A has more points than Team B \
And the time in the 4th quarter has expired \
And the ball is dead \
And the referee has declared the period ended \
And there are no penalties \
Then Team A wins the game

## Scenario: Two Teams have Equal Points
Given Team A and Team B have the same number of points \
And the time in the 4th quarter has expired \
And the ball is dead \
And the referee has declared the period ended \
And there are no penalties \
Then the first period of overtime begins

## Scenario: Overtime First Period Ending with Unequal Points
Given Team A and Team B have the same number of points \
And the fourth period has concluded \
And it is the first period of overtime \
Then the teams will conduct a coin toss \
And the ball will be placed at the 25 yard line \
And each team will have a single possession of the football \
And each team will retain possession until they score or fail to make a first down \
And Team A scores more points than Team B in the period \
Then Team A wins the game

## Scenario: Overtime First Period Ending with Equal Points
Given Team A and Team B have the same number of points \
And the fourth period has concluded \
And it is the first period of overtime \
Then the ball will be placed at the 25 yard line \
And each team will have a single possession of the football \
And each team will retain possession until they score or fail to make a first down \
And Team A and B score the same number of points in the period \
Then the second period of overtime begins

## Scenario: Overtime Second Period Ending with Unequal Points
Given Team A and Team B have the same number of points \
And the first period of overtime has concluded \
Then the ball will be placed at the 25 yard line \
And each team will have a single possession of the football \
And each team will retain possession until they score or fail to make a first down \
And each team will attempt a 2 point conversion \
And Team A scores more points than Team B in the period \
Then Team A wins

## Scenario: Overtime Second Period Ending with Equal Points
Given Team A and Team B have the same number of points \
And the first period of overtime has concluded \
Then the ball will be placed at the 25 yard line \
And each team will have a single possession of the football \
And each team will retain possession until they score or fail to make a first down \
And each team will attempt a 2 point conversion \
And Team A and B score the same number of points in the period \
Then the third period of overtime begins

## Scenario: Overtime Third Period and Beyond Ending with Unequal Points
Given Team A and Team B have the same number of points \
And the second or previous overtime period has concluded \
Then the ball will be placed on the 3 yard line \
And each team will have a single possession of the football \
And each team will have a single attempt to complete a 2 point try \
And Team A scores more points than Team B in the period \
Then Team A wins

## Scenario: Overtime Third Period and Beyond Ending with Equal Points
Given Team A and Team B have the same number of points \
And the second or previous overtime period has concluded \
Then the ball will be placed on the 3 yard line \
And each team will have a single possession of the football \
And each team will have a single attempt to complete a 2 point try \
And Team A and B score the same number of points in the period \
Then another period of overtime will begin

## Scenario: Forfeit
Given Team A and Team B have the same number of points \
And Team B forfeits the game \
Then Team A wins the game 
