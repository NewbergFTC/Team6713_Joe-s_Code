package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Tank Drive")
public class DriverOpMode extends LinearOpMode
{
/*
Driver TeleOp mode for Team 6713 2016-17 Velocity Vortex
*/
    @Override
    public void runOpMode() throws InterruptedException
    {
        //Declaring motors --> DcMotor motorNameinCode = hardwareMap.dcmotor.get("motorNameinPhoneConfig")
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRight");

        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRight");

        DcMotor launcherMotor = hardwareMap.dcMotor.get("launcher");
        DcMotor collectorMotor = hardwareMap.dcMotor.get("collector");

        //Declaring variables for the launcher loop in opModeIsActive
        //boolean launcherJustRelease = false;
        //int launcherStartPos = 0;

        //launcherMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //initializes the encoder for the launcher motor

        waitForStart(); //Wait for pushing the play button

        while (opModeIsActive()) //When the play button is going...
        {
            /*
            Note: The left side in the float statement below is negative because the motor is flipped,
            therefore forward on the right side is backward on the left
             */
            float leftStickY = -gamepad1.left_stick_y;
            float rightStickY = gamepad1.right_stick_y;

            /*
            Since the controller stick values are exactly 1 pressed fully forwards and -1 pulled fully
            backwards the controller values can be directly used by the motor setPower
             */
            frontLeftMotor.setPower(leftStickY);
            backLeftMotor.setPower(leftStickY);

            frontRightMotor.setPower(rightStickY);
            backRightMotor.setPower(rightStickY);

            //This is where the launcher variables are used
            if (gamepad1.a) //If the 'A' button is pressed...
            {

                /*
                The 'if' statement directly below sets the point at which the launcherMotor returns to once the 'A' button is released
                 */
                //if (!launcherJustRelease) //If the launcherJustRelease variable is false (Note: The launcherJustRelease is initialized as false) then the loop below runs
                {
                  //  launcherMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //Makes sure the motor is initialized

                    //idle(); //Makes sure the above code in this 'if' statement is running and complete

                   // launcherStartPos = launcherMotor.getCurrentPosition(); //gets the encoder value and sets it as the starting position
                }

                /*
                The rest of the 'if' statement runs if the 'A' button is pressed with no requirements from the launcherJustRelease variable
                 */




                launcherMotor.setPower(1);
                //launcherJustRelease = true; //This allows the loop within the 'else' statement below to run
            }
            else //When the 'A' button is released...
            {
               launcherMotor.setPower(0);

                /*
                If the variable launcherJustRelease is true then the loop below runs...
                (Note: The launcherJustRelease is changed to false after the 'A' button is pressed)
                 */
                //if (launcherJustRelease)
                {
                    //launcherMotor.setTargetPosition(launcherStartPos); //Sets the target position that the launcherMotor should return to (Which is the starting Position)
                    //launcherMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION); //Tells the motor to run back to the position set above (Which is the starting Position)

                    //idle(); //Makes sure the above code runs

                    //launcherMotor.setPower(1.0); //Sets the power to 1

                    //launcherJustRelease = false; //Sets the variable launcherJustRelease back to false so the above if(!launcherJustRelease) statement can be ran
                }
            }

            if (gamepad1.right_bumper) //If the right bumper is pressed...
            {
                collectorMotor.setPower(1); //Sets motor power to 1
            }
            else //If the right bumper is released...
            {
                collectorMotor.setPower(0); //Turns the motor off
            }

            if (gamepad1.left_bumper) //If the left bumper is pressed...
            {
                collectorMotor.setPower(-1); //Sets motor power to -1
            }
            else //If the left bumper is released...
            {
                collectorMotor.setPower(0); //Turns the motor off
            }
            idle(); //Makes sure that ALL of the above loops have run
        }
    }
}
