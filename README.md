# Compiler

main function is in CompilerMain

At the moment only accepts floats, factorial, cos, +,-, * and (). Will try to implement division (/) at a later date. 

cos will treat all input as radian

Sample input: -33e-2+24.32*((5*cos 60) - -3e5 *2) + 6!

output:
Evaluating -33e-2+24.32*((5*cos 60) - -3e5 *2) + 6!

cos60.0 = -0.9524129804151563

5.0 * -0.95241296 = -4.762065

-300000.0 * 2.0 = -600000.0

-4.762065 - -600000.0 = 599995.25

24.32 * 599995.25 = 1.4591884E7

-0.33 + 1.4591884E7 = 1.4591884E7

6.0! = 720.0

1.4591884E7 + 720.0 = 1.4592604E7

Answer: 1.4592604E7
