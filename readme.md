# AIM

The aim of my project is to compute the centroid and area moment of inertia of the given figures:
* Rectangular Channel
* Rectangular Channel with Slot
* MI and centroid of One Composite Section
* Triangle 


about x -axis, y-axis and about any given axis.


# THEORY

What is Moment of Inertia?
 
The moment of inertia is defined as the quantity expressed by the body resisting angular acceleration which is the sum of the product of the mass of every particle with its square of a distance from the axis of rotation. ... It is also known as the angular mass or rotational inertia.

What are the Factors on which the moment of inertia Depends?
* The density of the material
* Shape and size of the body
* Axis of rotation (distribution of mass relative to the axis)

# ALGORITHM


The basic concept of how we find the Moment of Inertia about any axis is finding the Moments about the Centroid of Area and then we find the moments about the global centroid and then we apply Parallel axis theorem to find the Moment about any axis , the deciding factor of the moment about any axis is the distance between the centroid and the required.

Next how we are asking the user the axis is Standard , we ask the user to enter the point and then about this point from the global centroid we find the moments x and y with respect to the global centroid .


The slots , for the slots we made an algorithm which can handle a maximum of 4 types slots  and if the user wants only one or two slots he/she could do that as well as as the algorithm is inbuilt , also we can calculate for 4 different (not same)slots at once , the basic logic is we have to subtracted each moment of four slots  about x and y to the main moment  and in case the user doesn’t need a particular slot he/she can enter the slot dimensions as (0,0) wherever needed and the moments will become 0 and there wouldn’t be change in net moment which implies there is no slot .

Net Moment = Main figure moment about x – Moment of circle about x –Moment of rectangle about x – Moment of triangle about x –Moment of square about x 

For detailed algorithm and project review click on this link https://github.com/robustTechie/MomentO/blob/master/Mechanics%20Report.pdf

