package Entity;

import Gameplay.Background;

public class pomocka {
    /*
    public void die() {
        if (counter == 20 && iterator < 3) {
            nowImage = this.imageArray[iterator];
            switch(iterator) {
                case 0: y += 20; break;
                case 2: y += 100; break;
            }
            iterator++;
            counter = 0;

        }
    }
    private void jump() {
        if (counter == 4) {
            if (jumpStages < 9) {
                switch(jumpStages) {
                    case 0: y = Background.getY(); break;
                    case 1: y -= 20; break;
                    case 2: y -= 50; break;
                    case 3: y -= 70; break;
                    case 4: y -= 20; break;
                    case 5: y += 20; break;
                    case 6: y += 70; break;
                    case 7: y += 50; break;
                    case 8: y += 20; break;
                }
                nowImage = this.imageArray[jumpStages];
                jumpStages++;
                counter = 0;
            } else {
                jumpStages = 0;
                action = Action.IDLE;
                onGround = true;
            }
        }
    }
    if (canMove) {
            double slow = 1;
            if (slowed) slow = 0.3;

            //actions
            if (this.keyInput.getRightPressed()) {
                this.x += this.speed * slow;
                if (onGround) {
                    action = Action.WALK;
                }
            }
            if (this.keyInput.getLeftPressed()) {
                this.x -= this.speed * slow;
                if (onGround) {
                    action = Action.WALK;
                }
            }
            if (this.keyInput.getUpPressed()) {
                action = Action.JUMP;
                onGround = false;
            }
            if (this.keyInput.getLeftReleased() || this.keyInput.getRightReleased() || this.keyInput.getFReleased()) {
                iterator = 0;
            }
            //run
            if (this.keyInput.getShiftPressed() && this.keyInput.getLeftPressed()) {
                this.x -= this.speed * 1.7 * slow;
                if (onGround) {
                    action = Action.RUN;
                }
            }
            if (this.keyInput.getShiftPressed() && this.keyInput.getRightPressed()) {
                this.x += this.speed * 1.7 * slow;
                if (onGround) {
                    action = Action.RUN;
                }
            }
            //shoot
            if (this.keyInput.getSpacePressed()) {
                if (onGround) {
                    if (shootChange) {
                        action = Action.SHOT1;
                    } else {
                        action = Action.SHOT2;
                    }
                    slowed = true;
                }
            }
            if (this.keyInput.getSpaceReleased()) {
                slowed = false;
            }
            //dead
            if (this.keyInput.getCPressed()) {
                action = Action.DEAD;
                canMove = false;
                iterator = 0;
            }
            //hurt
            if (this.keyInput.getVPressed()) {
                action = Action.HURT;
                canMove = false;
            }
            //attack
            if (this.keyInput.getFPressed()) {
                if (onGround) {
                    action = Action.ATTACK;
                    canMove = false;
                    iterator = 0;
                }
            }
        }
        //arrow animations
        if(action == Action.SHOT1 || action == Action.SHOT2) {
            if (iterator == 12) {
                this.arrow.setShot(true);
                arrow.setX(x+110);
                arrow.setY(y+100);
            }
        }
    */
}
