#encoding: utf-8
include Singleton

module NapakalakiGame
  class CardDealer
    
    def initialize
      @unusedTreasures = Array.new
      @usedTreasures = Array.new
      @unusedMonsters = Array.new
      @usedMonsters = Array.new
    end
    def initTreasureCardDeck

    end

    def initMonsterCardDeck
      #3 Byakhees de bonanza
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("3 Byakhees de bonanza", 8, badConsequence, prize)

      #Chibithulhu
      badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Chibithulhu", 2, badConsequence, prize)

      #El sopor de Dunwich
      badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El sopor de Dunwich", 2, badConsequence, prize)

      #Ángeles de la noche ibicenca
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      prize = Prize.new(4, 1)
      @unusedMonsters << Monster.new("Angeles de la noche ibicenca", 14, badConsequence, prize)

      #El gorrón en el umbral
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, 10, 0)
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("El górron en el umbral", 10, badConsequence, prize)

      #H.P. Munchcraft
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("H.P. Munchcraft", 6, badConsequence, prize)

      #Bichgooth
      badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bichgooth", 2, badConsequence, prize)

      #El rey de rosa
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
      prize = Prize.new(4, 2)
      @unusedMonsters << Monster.new("El rey de rosa", 13, badConsequence, prize)

      #La que redacta en las tinieblas
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("La que redacta en las tinieblas", 2, badConsequence, prize)

      #Los hondos
      badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Los hondos", 8, badConsequence, prize)

      #Semillas Cthulhu
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Semillas Cthulhu", 4, badConsequence, prize)

      #Dameargo
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Dameargo", 1, badConsequence, prize)

      #Pollipólipo volante
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Pollipólipo volante", 3, badConsequence, prize)

      #Yskhtihyssg-Goth
      badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("Yskhtihyssg-Goth", 12, badConsequence, prize)

      #Familia feliz
      badConsequence = BadConsequence.newDeath("La familia te atrapa. Estas muerto")
      prize = Prize.new(4, 1)
      @unusedMonsters << Monster.new("Familia feliz", 1, badConsequence, prize)

      #Roboggoth
      badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Roboggoth", 8, badConsequence, prize)

      #El espía
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El espía", 5, badConsequence, prize)

      #El lenguas
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El lenguas", 20, badConsequence, prize)

      #Bicéfalo
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bicéfalo", 20, badConsequence, prize)

    end

    def shuffleTreasures

    end

    def shuffleMonsters

    end

    def nextTreasure
  
    end

    def  nextMonster
  
    end

    def giveTreasureBack(t)

    end
    
    def giveMonsterBack(t)

    end

    def initCards

    end
    
    private :initTreasureCardDeck, :initMonsterCardDeck, :shuffleTreasures, :shuffleMonsters
    
  end
end
