# HeroArenaSimulator
 Project that simulates battles between heroes, with the purpose of learning OOP and design patterns. 
 
 
 ## Short overview
 
 The game consists of multiple **battle rounds** between heroes. The battles take place on a **bi-dimensional matrix map**, each cell having one of the following type
 of **terrains**: *land*, *desert*, *vulcano* or *wood*. Each type of hero has it's **unique abilities**, **strengths** and **weaknesses**. The **angels** are benevolent or harmful entities that cast abilities over the heroes, giving bonuses or inflicting damage. 
 Everything that happens in the batlles is **supervised** by an omniscient being: the **Great Magician**. 
 
 
 ## Features
 
 * ### Map
   * The map is a **N x N bi-dimensional matrix**, with cells having **4 different types of terrains**: land, wood, desert and vulcano. 
 
 * ### Heroes
   * There are **4 types of heroes**: wizards, knights, pyromancers and rogues. More can be easily added by further extending the abstract AHero class.
   * Each type of hero has it's **unique abilities**. More can be easily added by further extending the abstract AAbility class, and with the use of the **factory** HeroesFactory class.
   * Each hero type of hero has **strengths** and **weaknesses**, against other heroes and on different terrain types.
   * Each round, the heroes choose between an **attack or defense** oriented **strategy**, which provide them with **life** or **damage bonuses**. 
 
 * ### Angels
    * There are **11 types** of angels, each **casting an ability** over a hero. The ability can either be **beneficial**: increase the hp/xp, or **harmful**: decrease the hp/xp or even kill the hero..
    * The casting of an ability over a hero can be seen as an operation done on data, thus teaching the **visitor pattern**.
    
 * ### Great Magician
    * The great magician has the role of an **observer** over the game. His **subjects** are the heroes. He is **notified** by the angels when they cast an ability over a hero, and by the heroes when 
    they die. 
 
 * ### Abilities
    * There are **8 abilities** in the game, each hero having 2: *Fireblast, Ignite, Execute, Slam, Drain, Deflect, Backstab, Paralysis*. They were creating by using a 
    factory, thus more can be easily added in the future.
    * The abilities can inflict a harmful buff over a hero, for a number of rounds. 
 
 * ### Battle statistics
    * The BattleStatistics class retains information about the **heroes' battles history**: total number of battles, total winnings, defeats, as
     well as retains one's status as alive / dead.
 
