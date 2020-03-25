package com.cooltechworks.creditcarddesign;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class FlipAnimator extends Animation {
	
	public static final int DIRECTION_X = 1, DIRECTION_Y = 2, DIRECTION_Z = 3;
    private Camera camera;

    private View fromView;

    private View toView;

    private final float centerX;

    private final float centerY;

    private boolean forward = true;

    private boolean visibilitySwapped;

    private int rotationDirection = DIRECTION_X;

    private int translateDirection = DIRECTION_Z;

    /**

     * @param fromView First view in the transition.
     * @param toView Second view in the transition.
     * @param centerX The center of the views in the x-axis.
     * @param centerY The center of the views in the y-axis.
     */
    public FlipAnimator(View fromView, View toView, int centerX, int centerY) {
        this.fromView = fromView;
        this.toView = toView;
        this.centerX = centerX;
        this.centerY = centerY;

        setDuration(500);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public int getRotationDirection() {
		return rotationDirection;
	}

	public void setRotationDirection(int rotationDirection) {
		this.rotationDirection = rotationDirection;
	}

	public int getTranslateDirection() {
		return translateDirection;
	}

	public void setTranslateDirection(int translateDirection) {
		this.translateDirection = translateDirection;
	}

    public void reverse() {
        forward = false;
        View temp = toView;
        toView = fromView;
        fromView = temp;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        camera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {


        final double radians = Math.PI * interpolatedTime;
        float degrees = (float) (180.0 * radians / Math.PI);


        if (interpolatedTime >= 0.5f) {
            degrees -= 180.f;

            if (!visibilitySwapped) {
                fromView.setVisibility(View.GONE);
                toView.setVisibility(View.VISIBLE);

                visibilitySwapped = true;
            }
        }

        if (forward)
            degrees = -degrees;

        final Matrix matrix = t.getMatrix();

        camera.save();
        
        if(translateDirection == DIRECTION_Z) {
        	camera.translate(0.0f, 0.0f, (float) (150.0 * Math.sin(radians)));
        }
        else if(translateDirection == DIRECTION_Y) {
        	camera.translate(0.0f,  (float) (150.0 * Math.sin(radians)), 0.0f);
        }
        else {
        	camera.translate( (float) (150.0 * Math.sin(radians)), 0.0f, 0.0f);
        }

        if(rotationDirection == DIRECTION_Z) {
        	camera.rotateZ(degrees);
        }
        else if(rotationDirection == DIRECTION_Y) {
        	camera.rotateY(degrees);
        }
        else {
        	camera.rotateX(degrees);
        }
        
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}