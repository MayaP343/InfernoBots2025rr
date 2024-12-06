package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ftc.LazyImu;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name = "--DanielSimpleAuton")

@Config
public class DanielSimpleAuton extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();

        Outtake outtake = new Outtake(hardwareMap);

        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();

        outtake.getSlideMotor().resetEncoder();

        while (opModeIsActive()) {
            outtake.stepSlideTo(Outtake.HIGH_BASKET_POSITION, dashboardTelemetry);

            dashboardTelemetry.update();
        }
    }
}
