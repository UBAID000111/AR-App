package com.example.arplacement

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.ArCoreApk
import com.google.ar.core.HitResult
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ARActivity : AppCompatActivity() {
    private lateinit var arFragment: ArFragment
    private var objectPlaced = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, _, _ ->
            if (objectPlaced) return@setOnTapArPlaneListener

            ModelRenderable.builder()
                .setSource(this, Uri.parse("drill1.glb"))
                .setIsFilamentGltf(true)
                .build()
                .thenAccept { modelRenderable ->
                    val anchor = hitResult.createAnchor()
                    val anchorNode = AnchorNode(anchor)
                    anchorNode.setParent(arFragment.arSceneView.scene)

                    val node = TransformableNode(arFragment.transformationSystem)
                    node.renderable = modelRenderable
                    node.setParent(anchorNode)
                    node.select()

                    objectPlaced = true
                }
                .exceptionally {
                    Toast.makeText(this, "Model load failed", Toast.LENGTH_SHORT).show()
                    null
                }
        }
    }
    override fun onResume() {
        super.onResume()

        val availability = ArCoreApk.getInstance().checkAvailability(this)
        if (availability.isUnsupported) {
            Toast.makeText(this, "AR not supported on this device", Toast.LENGTH_LONG).show()
            finish()
        }
    }

}
