Game game;
boolean released = true;


void setup(){
  frameRate(60);
  size(1420, 850);
  
  game = new Game();
  game.initBoard();
  game.add();

  game.printM();
  
 
}



void draw(){
  background(205,193,180); //set white background
  
  fill(187,173,160); //set colour for game board
  rect( 0 , 0, 850, 850); //draw gameboard
  
  rect( 1000 , 0, 420, 850);
  
  fill(255);
  textAlign(CENTER, CENTER);
  textSize(80);
  text("Score: ", 1210 , 110);
  text(game.getScore(), 1210 , 210);
  
  
  
  
  fill(205,193,180); //set colour for boxes  
  noStroke();
  
  
  
  
  for( int x=0; x<4; x++){
    for( int y=0; y<4; y++){
      
 
      int value = game.getValue(y,x);
      
      if(value==0){
        fill(205,193,180);
        
      }
      else{
        fill(getColour(value));
      }
      
     
      rect( (210*x) + 10 , (210*y) + 10, 200, 200);

      if(value!=0){
        fill(255);
        textAlign(CENTER, CENTER);
        textSize(50);
        text(value, (210*x) + 110 , (210*y) + 110);
     
      }        
    }
  }
  
  if(game.getState().equals("Lost")){
    textSize(100);
    textAlign(CENTER, CENTER);
    text("GAME OVER", 425,425);  
  }
  
}

void keyPressed() {
  if (released) {
    switch(key) {
    case CODED:
      switch(keyCode) {
      case UP:
        game.moveUp();
        break;
      case DOWN:
        game.moveDown();
        break;
      case LEFT:
        game.moveLeft();
        break;
      case RIGHT:
        game.moveRight();
        break;
      }
    }
    game.printM();
    game.add();
    
    print("Score" + game.getScore() + game.getState() + "\n");
    
    released = false;
  }
}

void keyReleased(){
 released = true;  
}

public color getColour(int value) {
    color colour = color(255,255,255);   
    switch(value) {
    case 2:
      colour = color(240, 230, 220);
      break;
    case 4:
      colour = color(240, 225, 200);
      break;       
    case 8:
      colour = color(240, 180, 120);
      break;
    case 16:
      colour = color(235, 150, 100);
      break;
    case 32:
      colour = color(245, 125, 95);
      break;
    case 64:
      colour = color(245, 95, 60);
      break;
    case 128:
      colour = color(240, 210, 115);
      break;
    case 256:
      colour = color(240,205,100);
      break;
    case 512:
      colour = color(240,200,80);
      break;
    case 1024:
      colour = color(240,200,65);
      break;
    case 2048:
      colour = color(240,200,1);
      break;
    case 4096:
      colour = color(95,220,145);
      break;
      
    }
    return colour;
  }



  
