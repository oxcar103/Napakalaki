#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Prize
  def initialize(t, l)
    @treasures = t
    @level = l
  end


  def getTreasures
    @treasures
  end
  
  def getLevels
    @level
  end
  
  #toString
  def to_s
    "\n\tTesoros ganados: #{@treasures} \n\tNiveles ganados: #{@level}"
  end
  
end
