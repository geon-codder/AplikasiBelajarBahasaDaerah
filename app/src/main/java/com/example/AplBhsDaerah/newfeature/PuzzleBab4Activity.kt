package com.example.AplBhsDaerah.newfeature

import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityPuzzlebab4Binding
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.example.AplBhsDaerah.home.sub.bab4.Berbicara4Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menulis4Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.io.IOException
import java.util.*

class PuzzleBab4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPuzzlebab4Binding
    var pieces: ArrayList<PuzzlePiece?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPuzzlebab4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val assetName = intent.getStringExtra("assetName")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            imageView.post {
                if (assetName != null) {
                    setPicFromAsset(assetName, imageView)
                }
                pieces = splitImage()
                val touchListener = assetName?.let { TouchListener(this@PuzzleBab4Activity, it) }
                Collections.shuffle(pieces)
                for (piece in pieces!!) {
                    piece!!.setOnTouchListener(touchListener)
                    layout.addView(piece)
                    // randomize position, on the bottom of the screen
                    val lParams = piece.layoutParams as RelativeLayout.LayoutParams
                    lParams.leftMargin = Random().nextInt(layout.width - piece.pieceWidth)
                    lParams.topMargin = layout.height - piece.pieceHeight
                    piece.layoutParams = lParams
                }
            }

        }

    }

    fun checkGameOver(assetName: String)  {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        val puzzleStatus = "done"
        if (isGameOver) {
            AlertDialog.Builder(this@PuzzleBab4Activity)
                .setTitle("Puzzle Complete")
                .setIcon(R.drawable.ic_celebration)
                .setMessage("Selamat...\nKamu telah menyelesaikan puzzle..!! ")
                .setCancelable(false)
                .setNegativeButton("Lanjutkan"){
                        dialog, _->
                    finish()
                    dialog.dismiss()
                    if(assetName == "puzzlebab4.png"){
//                        saveScoreBab4()
                        if (getUserEmail != null) {
                            val skorAkhir = 100
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab4").setValue(skorAkhir)
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab4").setValue(puzzleStatus)
                        }
                        val intent = Intent(this, SubBab4Activity::class.java)
                        startActivity(intent)
                    }else if(assetName == "puzzlebab5.png"){
//                        saveScoreBab5()
                        if (getUserEmail != null) {
                            val skorAkhir = 100
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab5").setValue(skorAkhir)
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab5").setValue(puzzleStatus)
                        }
                        val intent = Intent(this, SubBab5Activity::class.java)
                        startActivity(intent)
                    }else if(assetName == "puzzlebab6.png"){
//                        saveScoreBab6()

                        if (getUserEmail != null) {
                            val skorAkhir = 100
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab6").setValue(skorAkhir)
                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab6").setValue(puzzleStatus)
                        }
                        val intent = Intent(this, SubBab6Activity::class.java)
                        startActivity(intent)
                    }
                }
                .create()
                .show()
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun saveScoreBab4(){

        val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
        val editor = pref.edit()

        editor.putInt("puzzle4", 100)
        editor.apply()

        Toast.makeText(this@PuzzleBab4Activity, "Puzzle diselesaikan, skor +100", Toast.LENGTH_SHORT).show()

    }

    private fun saveScoreBab5(){

        val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
        val editor = pref.edit()

        editor.putInt("puzzle5",100)
        editor.apply()

        Toast.makeText(this@PuzzleBab4Activity, "Puzzle diselesaikan, skor +100", Toast.LENGTH_SHORT).show()

    }

    private fun saveScoreBab6(){

        val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
        val editor = pref.edit()

        editor.putInt("puzzle6", 100)
        editor.apply()

        Toast.makeText(this@PuzzleBab4Activity, "Puzzle diselesaikan, skor +100", Toast.LENGTH_SHORT).show()

    }

    private val isGameOver: Boolean
        get() {
            for (piece in pieces!!) {
                if (piece!!.canMove) {
                    return false
                }
            }
            return true
        }

    private fun setPicFromAsset(assetName: String, imageView: ImageView) {
        // Get the dimensions of the View
        val targetW = imageView.width
        val targetH = imageView.height
        val am = assets
        try {
            val `is` = am.open(assetName)
            // Get the dimensions of the bitmap
            val bmOptions = BitmapFactory.Options()
            bmOptions.inJustDecodeBounds = true
            BitmapFactory.decodeStream(`is`, Rect(-1, -1, -1, -1), bmOptions)
            val photoW = bmOptions.outWidth
            val photoH = bmOptions.outHeight

            // Determine how much to scale down the image
            val scaleFactor = Math.min(photoW / targetW, photoH / targetH)
            `is`.reset()

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false
            bmOptions.inSampleSize = scaleFactor
            bmOptions.inPurgeable = true
            val bitmap = BitmapFactory.decodeStream(`is`, Rect(-1, -1, -1, -1), bmOptions)
            imageView.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun splitImage(): ArrayList<PuzzlePiece?> {
        val piecesNumber = 12
        val rows = 4
        val cols = 3
        val imageView = findViewById<ImageView>(R.id.imageView)
        val pieces = ArrayList<PuzzlePiece?>(piecesNumber)

        // Get the scaled bitmap of the source image
        val drawable = imageView.drawable as BitmapDrawable
        val bitmap = drawable.bitmap
        val dimensions = getBitmapPositionInsideImageView(imageView)
        val scaledBitmapLeft = dimensions[0]
        val scaledBitmapTop = dimensions[1]
        val scaledBitmapWidth = dimensions[2]
        val scaledBitmapHeight = dimensions[3]
        val croppedImageWidth = scaledBitmapWidth - 2 * Math.abs(scaledBitmapLeft)
        val croppedImageHeight = scaledBitmapHeight - 2 * Math.abs(scaledBitmapTop)
        val scaledBitmap =
            Bitmap.createScaledBitmap(bitmap, scaledBitmapWidth, scaledBitmapHeight, true)
        val croppedBitmap = Bitmap.createBitmap(
            scaledBitmap,
            Math.abs(scaledBitmapLeft),
            Math.abs(scaledBitmapTop),
            croppedImageWidth,
            croppedImageHeight
        )

        // Calculate the with and height of the pieces
        val pieceWidth = croppedImageWidth / cols
        val pieceHeight = croppedImageHeight / rows

        // Create each bitmap piece and add it to the resulting array
        var yCoord = 0
        for (row in 0 until rows) {
            var xCoord = 0
            for (col in 0 until cols) {
                // calculate offset for each piece
                var offsetX = 0
                var offsetY = 0
                if (col > 0) {
                    offsetX = pieceWidth / 3
                }
                if (row > 0) {
                    offsetY = pieceHeight / 3
                }

                // apply the offset to each piece
                val pieceBitmap = Bitmap.createBitmap(
                    croppedBitmap,
                    xCoord - offsetX,
                    yCoord - offsetY,
                    pieceWidth + offsetX,
                    pieceHeight + offsetY
                )
                val piece = PuzzlePiece(applicationContext)
                piece.setImageBitmap(pieceBitmap)
                piece.xCoord = xCoord - offsetX + imageView.left
                piece.yCoord = yCoord - offsetY + imageView.top
                piece.pieceWidth = pieceWidth + offsetX
                piece.pieceHeight = pieceHeight + offsetY

                // this bitmap will hold our final puzzle piece image
                val puzzlePiece = Bitmap.createBitmap(
                    pieceWidth + offsetX,
                    pieceHeight + offsetY,
                    Bitmap.Config.ARGB_8888
                )

                // draw path
                val bumpSize = pieceHeight / 4
                val canvas = Canvas(puzzlePiece)
                val path = Path()
                path.moveTo(offsetX.toFloat(), offsetY.toFloat())
                if (row == 0) {
                    // top side piece
                    path.lineTo(pieceBitmap.width.toFloat(), offsetY.toFloat())
                } else {
                    // top bump
                    path.lineTo(
                        (offsetX + (pieceBitmap.width - offsetX) / 3).toFloat(),
                        offsetY.toFloat()
                    )
                    path.cubicTo(
                        (offsetX + (pieceBitmap.width - offsetX) / 6).toFloat(),
                        (offsetY - bumpSize).toFloat(),
                        (offsetX + (pieceBitmap.width - offsetX) / 6 * 5).toFloat(),
                        (offsetY - bumpSize).toFloat(),
                        (offsetX + (pieceBitmap.width - offsetX) / 3 * 2).toFloat(),
                        offsetY.toFloat()
                    )
                    path.lineTo(pieceBitmap.width.toFloat(), offsetY.toFloat())
                }
                if (col == cols - 1) {
                    // right side piece
                    path.lineTo(pieceBitmap.width.toFloat(), pieceBitmap.height.toFloat())
                } else {
                    // right bump
                    path.lineTo(
                        pieceBitmap.width.toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 3).toFloat()
                    )
                    path.cubicTo(
                        (pieceBitmap.width - bumpSize).toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 6).toFloat(),
                        (pieceBitmap.width - bumpSize).toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 6 * 5).toFloat(),
                        pieceBitmap.width.toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 3 * 2).toFloat()
                    )
                    path.lineTo(pieceBitmap.width.toFloat(), pieceBitmap.height.toFloat())
                }
                if (row == rows - 1) {
                    // bottom side piece
                    path.lineTo(offsetX.toFloat(), pieceBitmap.height.toFloat())
                } else {
                    // bottom bump
                    path.lineTo(
                        (offsetX + (pieceBitmap.width - offsetX) / 3 * 2).toFloat(),
                        pieceBitmap.height.toFloat()
                    )
                    path.cubicTo(
                        (offsetX + (pieceBitmap.width - offsetX) / 6 * 5).toFloat(),
                        (pieceBitmap.height - bumpSize).toFloat(),
                        (offsetX + (pieceBitmap.width - offsetX) / 6).toFloat(),
                        (pieceBitmap.height - bumpSize).toFloat(),
                        (offsetX + (pieceBitmap.width - offsetX) / 3).toFloat(),
                        pieceBitmap.height.toFloat()
                    )
                    path.lineTo(offsetX.toFloat(), pieceBitmap.height.toFloat())
                }
                if (col == 0) {
                    // left side piece
                    path.close()
                } else {
                    // left bump
                    path.lineTo(
                        offsetX.toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 3 * 2).toFloat()
                    )
                    path.cubicTo(
                        (offsetX - bumpSize).toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 6 * 5).toFloat(),
                        (offsetX - bumpSize).toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 6).toFloat(),
                        offsetX.toFloat(),
                        (offsetY + (pieceBitmap.height - offsetY) / 3).toFloat()
                    )
                    path.close()
                }

                // mask the piece
                val paint = Paint()
                paint.color = -0x1000000
                paint.style = Paint.Style.FILL
                canvas.drawPath(path, paint)
                paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
                canvas.drawBitmap(pieceBitmap, 0f, 0f, paint)

                // draw a white border
                var border = Paint()
                border.color = -0x7f000001
                border.style = Paint.Style.STROKE
                border.strokeWidth = 8.0f
                canvas.drawPath(path, border)

                // draw a black border
                border = Paint()
                border.color = -0x80000000
                border.style = Paint.Style.STROKE
                border.strokeWidth = 3.0f
                canvas.drawPath(path, border)

                // set the resulting bitmap to the piece
                piece.setImageBitmap(puzzlePiece)
                pieces.add(piece)
                xCoord += pieceWidth
            }
            yCoord += pieceHeight
        }
        return pieces
    }

    private fun getBitmapPositionInsideImageView(imageView: ImageView?): IntArray {
        val ret = IntArray(4)
        if (imageView == null || imageView.drawable == null) return ret

        // Get image dimensions
        // Get image matrix values and place them in an array
        val f = FloatArray(9)
        imageView.imageMatrix.getValues(f)

        // Extract the scale values using the constants (if aspect ratio maintained, scaleX == scaleY)
        val scaleX = f[Matrix.MSCALE_X]
        val scaleY = f[Matrix.MSCALE_Y]

        // Get the drawable (could also get the bitmap behind the drawable and getWidth/getHeight)
        val d = imageView.drawable
        val origW = d.intrinsicWidth
        val origH = d.intrinsicHeight

        // Calculate the actual dimensions
        val actW = Math.round(origW * scaleX)
        val actH = Math.round(origH * scaleY)
        ret[2] = actW
        ret[3] = actH

        // Get image position
        // We assume that the image is centered into ImageView
        val imgViewW = imageView.width
        val imgViewH = imageView.height
        val top = (imgViewH - actH) / 2
        val left = (imgViewW - actW) / 2
        ret[0] = left
        ret[1] = top
        return ret
    }

}