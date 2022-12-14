/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.hilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.android.hilt.R
import com.example.android.hilt.data.LoggerLocalDataSource
import com.example.android.hilt.databinding.FragmentButtonsBinding
import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays buttons whose interactions are recorded.
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject lateinit var logger: LoggerLocalDataSource
    @Inject lateinit var navigator: AppNavigator
    private lateinit var binding: FragmentButtonsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        button1.setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        button2.setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        button3.setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        allLogs.setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        deleteLogs.setOnClickListener {
            logger.removeLogs()
        }
    }
}
