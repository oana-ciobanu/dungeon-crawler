package GameEngine;

public interface IBattlefield {
     void GameOver();
     void EnemyKilled();
     void UseSpellFinished(int damage);
     void HitAgain();
     void RunAwayFinishedOrNot();
     void RunAwayAndEscaped();
     void TriedToEscapeAndGotCaught();

}

